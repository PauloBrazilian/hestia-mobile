package hestia.ms_notification.application.service;

import hestia.ms_notification.application.ports.in.EmailService;
import hestia.ms_notification.domain.dto.EmailDto;
import hestia.ms_notification.domain.enums.StatusEmail;
import hestia.ms_notification.domain.mapper.ClassMapper;
import hestia.ms_notification.framework.adapters.out.persistence.EmailRepository;
import hestia.ms_notification.framework.helper.EmailBodyBuilder;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.Base64;

@AllArgsConstructor
@Transactional
@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository repository;
    private final ClassMapper mapper;
    private final JavaMailSenderImpl javaMailSender;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final EmailBodyBuilder emailBodyBuilder;
    private final ResourceLoader resourceLoader;

    @Override
    public String emailWelcome(EmailDto emailDto) {
        var email = mapper.dtoToEmail(emailDto);

        try {
            Resource resource = resourceLoader.getResource("classpath:templates/mc-poze-mo-paz.png");
            byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());
            String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
            email.setImageBase64(imageBase64);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load image", e);
        }

        String emailBody = emailBodyBuilder.buildWelcomeEmail("cid:image", email.getBody());
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email.getReplyTo());
            helper.setSubject(email.getSubject());
            helper.setText(emailBody, true);
            helper.setFrom(email.getFromEmail(), email.getSubject());


            if (email.getImageBase64() != null) {
                byte[] imageBytes = Base64.getDecoder().decode(email.getImageBase64());
                helper.addInline("image", new ByteArrayResource(imageBytes), "image/png");
            }

            javaMailSender.send(message);
            email.setStatusEmail(StatusEmail.SEND);
        } catch (MessagingException | UnsupportedEncodingException e) {
            email.setStatusEmail(StatusEmail.FAILED);
            throw new RuntimeException(e);
        }

        repository.save(email);
        kafkaTemplate.send("Topic", String.valueOf(emailDto));
        mapper.emailToDto(email);
        return "Send Email with Success";
    }

}
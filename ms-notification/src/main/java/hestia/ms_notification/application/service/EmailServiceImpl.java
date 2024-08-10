package hestia.ms_notification.application.service;

import hestia.ms_notification.application.ports.in.EmailService;
import hestia.ms_notification.domain.dto.EmailDto;
import hestia.ms_notification.domain.enums.StatusEmail;
import hestia.ms_notification.domain.mapper.ClassMapper;
import hestia.ms_notification.framework.adapters.out.persistence.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@AllArgsConstructor
@Transactional
@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository repository;
    private final ClassMapper mapper;
    private final JavaMailSenderImpl javaMailSender;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public String emailWelcome(EmailDto emailDto) {
        var email = mapper.dtoToEmail(emailDto);
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email.getReplyTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getBody(), true);
            helper.setFrom(email.getFromEmail(), email.getFromName());
            javaMailSender.send(message);
            email.setStatusEmail(StatusEmail.SEND);
        } catch (MessagingException e) {
            email.setStatusEmail(StatusEmail.FAILED);
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        repository.save(email);
        kafkaTemplate.send("Topic", String.valueOf(message));
        mapper.emailToDto(email);
        return "Send Email with Success";
    }

}
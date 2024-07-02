package hestia.ms_notification.application.service;

import hestia.ms_notification.application.ports.in.EmailService;
import hestia.ms_notification.domain.dto.EmailDto;
import hestia.ms_notification.domain.mapper.ClassMapper;
import hestia.ms_notification.framework.adapters.out.persistence.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository repository;

    private final ClassMapper mapper;

    private final JavaMailSenderImpl javaMailSender;

    @Override
    public EmailDto emailWelcome(EmailDto emailDto) {
        return null;
    }
}

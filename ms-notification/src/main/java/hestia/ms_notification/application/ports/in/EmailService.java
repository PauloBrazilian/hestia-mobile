package hestia.ms_notification.application.ports.in;

import hestia.ms_notification.domain.dto.EmailDto;

public interface EmailService {

    EmailDto emailWelcome(EmailDto emailDto);

}

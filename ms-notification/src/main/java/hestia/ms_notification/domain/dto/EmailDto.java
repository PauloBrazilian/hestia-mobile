package hestia.ms_notification.domain.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    private String fromEmail;
    private String fromName;
    private String replyTo;
    private String subject;
    private String body;
    private String contentType;
}

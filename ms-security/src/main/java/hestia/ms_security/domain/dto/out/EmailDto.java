package hestia.ms_security.domain.dto.out;

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
}

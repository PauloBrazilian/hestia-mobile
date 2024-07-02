package hestia.ms_notification.domain.model;

import hestia.ms_notification.domain.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;
    private String fromEmail;
    private String fromName;
    private String replyTo;
    private String subject;
    @Column(name = "TEXT")
    private String body;
    private String contentType;
    private StatusEmail statusEmail;

}

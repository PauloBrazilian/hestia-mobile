package hestia.ms_notification.domain.model;

import hestia.ms_notification.domain.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    private StatusEmail statusEmail;

}

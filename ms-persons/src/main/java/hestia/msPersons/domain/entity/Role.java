package hestia.msPersons.domain.entity;

import hestia.msPersons.domain.enums.AuthorizationEnum;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String token;

    @Enumerated(EnumType.STRING)
    private AuthorizationEnum access;

}

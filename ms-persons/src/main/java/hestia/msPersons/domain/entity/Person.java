package hestia.msPersons.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private Boolean active;

    private String email;

    private String name;

    private String password;

    private String personImg;

    @OneToOne(targetEntity = Role.class)
    private Role role;

}
package hestia.msPersons.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "Business")
public class PersonBUSS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personBussId;

    private Boolean active;

    private String address;

    private String city;

    @Column(name = "CNPJ")
    @JsonProperty("cnpj")
    private String cnpj;

    private String district;

    private String email;

    private String name;

    private String number;

    private String password;

    private String personImg;

    @Column(name = "UF")
    @JsonProperty("UF")
    private String uf;

    @OneToOne(targetEntity = Role.class)
    private Role role;
}
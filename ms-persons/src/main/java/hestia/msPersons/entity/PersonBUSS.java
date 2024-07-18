package hestia.msPersons.entity;

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
    private int personBussId;

    @Column(name = "CNPJ")
    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("address")
    private String address;

    @JsonProperty("number")
    private String number;

    @JsonProperty("district")
    private String district;

    @JsonProperty("city")
    private String city;

    @Column(name = "UF")
    @JsonProperty("UF")
    private String uf;

    @JsonProperty("name")
    private String name;

    @JsonProperty("personImg")
    private String personImg;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    private boolean active;
}
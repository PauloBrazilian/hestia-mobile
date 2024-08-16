package hestia.msPersons.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonBussDto {

    private Long personBussId;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    @CNPJ(message = "CNPJ is not valid")
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "Invalid CNPJ format. It should be XX.XXX.XXX/XXXX-XX.")
    @JsonProperty("CNPJ")
    private String cnpj;

    @NotBlank
    private String district;

    @NotBlank
    @Email(message = "Invalid Email.")
    @Pattern(regexp = "\\w.@gmail.com", message = "Invalid Email format. It should be xxx@gmail.com")
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 3, max = 5, message = "The number must have exactly 5 digits.")
    private String number;

    @NotBlank
    private String password;

    @NotBlank
    private String personImg;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{2}$", message = "UF must have a maximum of 2 characters.")
    @JsonProperty("UF")
    private String uf;

    private RoleDto roleDto;

}
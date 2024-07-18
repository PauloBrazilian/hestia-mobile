package hestia.msPersons.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @CNPJ(message = "CNPJ is not valid")
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "Invalid CNPJ format. It should be XX.XXX.XXX/XXXX-XX.")
    @JsonProperty("CNPJ")
    private String cnpj;

    @NotNull
    @JsonProperty("address")
    private String address;

    @NotNull
    @Size(min = 3, max = 5, message = "The number must have exactly 5 digits.")
    @JsonProperty("number")
    private String number;

    @NotNull
    @JsonProperty("district")
    private String district;

    @NotNull
    @JsonProperty("city")
    private String city;

    @NotNull
    @Pattern(regexp = "^[A-Z]{2}$", message = "UF must have a maximum of 2 characters.")
    @JsonProperty("UF")
    private String uf;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("personImg")
    private String personImg;

    @NotNull
    @Email(message = "Invalid Email.")
    @Pattern(regexp = "\\w.@gmail.com", message = "Invalid Email format. It should be xxx@gmail.com")
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("password")
    private String password;

}
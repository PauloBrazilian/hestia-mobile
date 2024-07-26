package hestia.ms_security.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

public record RegisterPersonBusRequestDto(

        @NotBlank
        @CNPJ(message = "CNPJ is not valid")
        @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "Invalid CNPJ format. It should be XX.XXX.XXX/XXXX-XX.")
        @JsonProperty("CNPJ")
        String cnpj,

        @NotBlank
        String address,

        @NotBlank
        @Size(min = 3, max = 5, message = "The number must have exactly 5 digits.")
        @JsonProperty("number")
        String number,

        @NotBlank
        String district,

        @NotBlank
        String city,

        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "UF must have a maximum of 2 characters.")
        @JsonProperty("UF")
        String uf,

        @NotBlank
        String name,

        @NotBlank
        @JsonProperty("personImg")
        String personImg,

        @NotBlank
        @Email(message = "Invalid Email.")
        @Pattern(regexp = "\\w.@gmail.com", message = "Invalid Email format. It should be xxx@gmail.com")
        String email,

        @NotBlank
        @Size(min = 8, message = "Password should have at least 8 characters")
        String password

) {
}

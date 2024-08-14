package hestia.ms_security.domain.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

public record PersonBussDto(

        @NotBlank
        Boolean active,

        @NotBlank
        String address,

        @NotBlank
        String city,

        @NotBlank
        @CNPJ(message = "CNPJ is not valid")
        @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "Invalid CNPJ format. It should be XX.XXX.XXX/XXXX-XX.")
        @JsonProperty("CNPJ")
        String cnpj,

        @NotBlank
        String district,

        @NotBlank
        @Email(message = "Invalid Email.")
        @Pattern(regexp = "\\w.@gmail.com", message = "Invalid Email format. It should be xxx@gmail.com")
        String email,

        @NotBlank
        String name,

        @NotBlank
        @Size(min = 3, max = 5, message = "The number must have exactly 5 digits.")
        @JsonProperty("number")
        String number,

        @NotBlank
        @Size(min = 8, message = "Password should have at least 8 characters")
        String password,

        @NotBlank
        @JsonProperty("personImg")
        String personImg,

        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "UF must have a maximum of 2 characters.")
        @JsonProperty("UF")
        String uf,

        @NotBlank
        RoleDto roleDto
) {
}

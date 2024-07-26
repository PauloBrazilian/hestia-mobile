package hestia.ms_security.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterPersonRequestDto(

        @NotBlank
        String name,

        @NotBlank
        String personImg,

        @NotBlank
        @Email(message = "Email is not falited")
        String email,

        @NotBlank
        @Size(min = 8, message = "Password should have at least 8 characters")
        String password

) {
}

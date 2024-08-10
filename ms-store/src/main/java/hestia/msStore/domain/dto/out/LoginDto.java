package hestia.msStore.domain.dto.out;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginDto(

        @Email(message = "Invalid Email.")
        @Pattern(regexp = "\\w.@gmail.com", message = "Invalid Email format. It should be xxx@gmail.com")
        String email,

        @NotBlank(message = "The password is null")
        @Size(min = 8, message = "Password should have at least 8 characters")
        String password

//        @NotBlank(message = "roles must be either 'AUTHORIZED' or 'UNAUTHORIZED'")
//        AuthorizationEnum access

) {
}

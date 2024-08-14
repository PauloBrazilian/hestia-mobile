package hestia.ms_security.domain.dto.in;

import hestia.ms_security.domain.enums.AuthorizationEnum;
import jakarta.validation.constraints.NotBlank;


public record RoleDto(

        @NotBlank
        Long id,

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String token,

        @NotBlank
        AuthorizationEnum access


) {
}
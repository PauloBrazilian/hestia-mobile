package hestia.msStore.domain.dto.out;

import hestia.msStore.domain.enums.AuthorizationEnum;
import jakarta.validation.constraints.NotBlank;


public record RoleDto(

        @NotBlank
        Long id,

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotBlank
        String token,

        @NotBlank
        AuthorizationEnum access


) {
}
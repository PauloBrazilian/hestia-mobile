package hestia.msPersons.domain.dto;

import hestia.msPersons.domain.enums.AuthorizationEnum;

public record RoleDto(

        Long id,

        String name,

        String email,

        String token,

        AuthorizationEnum access

) {
}

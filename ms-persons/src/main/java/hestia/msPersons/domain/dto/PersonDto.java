package hestia.msPersons.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {

    private Long personId;

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotBlank
    @Email(message = "Email is not falited")
    @JsonProperty("email")
    private String email;

    @NotBlank
    @Size(min = 8, message = "Password should have at least 8 characters")
    @JsonProperty("password")
    private String password;

    @NotBlank
    @JsonProperty("personImg")
    private String personImg;

    @JsonProperty("roles")
    private RoleDto roleDto;

}
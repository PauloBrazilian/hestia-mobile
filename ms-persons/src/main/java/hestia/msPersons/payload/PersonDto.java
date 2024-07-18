package hestia.msPersons.payload;

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

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotBlank
    @JsonProperty("personImg")
    private String personImg;

    @NotBlank
    @Email(message = "Email is not falited")
    @JsonProperty("email")
    private String email;

    @NotBlank
    @Size(min = 6, max = 8)
    @JsonProperty("password")
    private String password;

}
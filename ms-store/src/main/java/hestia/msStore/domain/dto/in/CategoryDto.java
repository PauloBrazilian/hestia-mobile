package hestia.msStore.domain.dto.in;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotNull(message = "The categoryName is null")
    private String categoryName;
}
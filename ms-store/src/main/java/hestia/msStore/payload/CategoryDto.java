package hestia.msStore.payload;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
public class CategoryDto {

    @NotNull(message = "The categoryName is null")
    private String categoryName;

    public CategoryDto(String categoryName) {
        this.categoryName = categoryName;
    }
}
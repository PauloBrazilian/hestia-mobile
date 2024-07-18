package hestia.msStore.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import hestia.msStore.model.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotNull(message = "The product name should not be empty")
    @Size(min = 3, message = "Product description should have at least 3 characters")
    @JsonProperty("name")
    private String productName;

    @NotNull(message = "The product name should not be empty")
    @Size(min = 1, message = "Product quantity should have at least 1")
    @JsonProperty("quantity")
    private Integer quantity;

    @NotNull(message = "The description should not be empty")
    @Size(min = 3, message = "Product description should have at least 3 characters")
    @JsonProperty("description")
    private String description;

    @NotNull(message = "The img product should not be empty")
    @JsonProperty("imgUrl")
    private String imgUrl;

    @NotNull
    @DecimalMin(value = "1", message = "The product price cant be less than 1")
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @JsonProperty("categories")
    private Category categories;

}
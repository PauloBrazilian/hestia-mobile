package hestia.msStore.domain.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import hestia.msStore.domain.model.Category;
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

    private Long productId;

    @NotNull(message = "The product name should not be empty")
    @Size(min = 3, message = "Product description should have at least 3 characters")
    @JsonProperty("name")
    private String productName;

    @NotNull(message = "The product name should not be empty")
    @Size(min = 1, message = "Product quantity should have at least 1")
    private Integer quantity;

    @NotNull(message = "The description should not be empty")
    @Size(min = 3, message = "Product description should have at least 3 characters")
    private String description;

    @NotNull(message = "The img product should not be empty")
    private String imgUrl;

    @NotNull
    @DecimalMin(value = "1", message = "The product price cant be less than 1")
    private BigDecimal price;

    @NotNull
    private Category categories;

    @JsonProperty("business")
    private String personBussName;

}
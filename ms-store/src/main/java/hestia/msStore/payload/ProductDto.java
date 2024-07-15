package hestia.msStore.payload;

import hestia.msStore.model.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.math.BigDecimal;

import java.util.Set;

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

    @NotNull(message = "The description should not be empty")
    @Size(min = 3, message = "Product description should have at least 3 characters")
    @JsonProperty("description")
    private String description;

    @NotNull(message = "The img product should not be empty")
    @JsonProperty("imgUrl")
    private String imgUrl;

    @NotNull
    @DecimalMin(value = "1",message = "The product price cant be less than 1")
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @JsonProperty("categories")
    private Category categories;

}
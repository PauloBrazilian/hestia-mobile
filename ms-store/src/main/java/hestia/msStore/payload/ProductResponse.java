package hestia.msStore.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    @NotNull(message = "The product name should not be empty")
    @Size(min = 3, message = "Product description should have at least 3 characters")
    @JsonProperty("name")
    private String productName;

    @NotNull
    @DecimalMin(value = "1",message = "The product price cant be less than 1")
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @DecimalMin(value = "1", message = "The product quantity cant be less than 1")
    @JsonProperty("quantity")
    private Integer quantity;

}
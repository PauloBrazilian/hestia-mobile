package hestia.msStore.payload;

import hestia.msStore.model.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.math.BigDecimal;

import java.util.Set;

@Getter @Setter @ToString
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

    public ProductDto(String productName, String description, String imgUrl, BigDecimal price, Category categories) {
        this.productName = productName;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.categories = categories;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
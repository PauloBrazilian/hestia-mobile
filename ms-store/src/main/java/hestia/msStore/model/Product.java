package hestia.msStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @JsonProperty("name")
    private String productName;

    private Integer quantity;

    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    @Column(nullable = false)
    @JsonIgnore
    private List<Lista> lists = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    @JsonProperty("category")
    private Category category;

}
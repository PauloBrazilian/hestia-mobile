package hestia.msStore.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "lists")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @JsonProperty("name")
    private String productName;

    private Integer quantity;

    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    private BigDecimal price;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Lista> lists;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category categories;

    private String personBussName;

}
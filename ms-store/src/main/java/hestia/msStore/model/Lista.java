package hestia.msStore.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Lista")
@Builder
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listaId;

    @Column(name = "name")
    @JsonProperty("name")
    private String listaName;

    private LocalDate data;

    @ManyToMany
    @JoinTable(name = "lista_product",
            joinColumns = @JoinColumn(name = "lista_id", referencedColumnName = "listaId"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

}
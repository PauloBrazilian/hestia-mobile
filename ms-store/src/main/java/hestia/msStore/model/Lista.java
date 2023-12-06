package hestia.msStore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name = "Lista")
public class Lista {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listaId;

    @Column(name = "name")
    private String listaName;

    @Column(name = "data")
    private LocalDate data;

    @ManyToMany
    @JoinTable(name = "lista_product",
            joinColumns = @JoinColumn(name = "lista_id", referencedColumnName = "listaId" ),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public int getListaId() {
        return listaId;
    }

    public void setListaId(int listaId) {
        this.listaId = listaId;
    }

    public String getListaName() {
        return listaName;
    }

    public void setListaName(String listaName) {
        this.listaName = listaName;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
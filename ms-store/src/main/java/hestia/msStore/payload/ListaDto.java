package hestia.msStore.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import hestia.msStore.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListaDto {

    @NotNull(message = "The name is null")
    @JsonProperty("name")
    private String listaName;

    @NotNull(message = "The name is null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("data")
    private LocalDate data;

    @JsonProperty("products")
    private List<ProductDto> products;

    public List<ProductDto> getProducts() {
        return products;
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

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

}
package hestia.msStore.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListaResponse {

    @NotNull(message = "The name is null")
    @JsonProperty("name")
    private String listaName;

    @JsonProperty("products")
    private List<ProductResponse> products;

    public String getListaName() {
        return listaName;
    }

    public void setListaName(String listaName) {
        this.listaName = listaName;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}
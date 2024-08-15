package hestia.msStore.domain.dto.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListaResponse {

    @NotNull(message = "The name is null")
    @JsonProperty("name")
    private String listaName;

    @JsonProperty("products")
    private List<ProductResponse> products;

    private BigDecimal total;

}
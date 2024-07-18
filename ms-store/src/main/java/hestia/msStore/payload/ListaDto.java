package hestia.msStore.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
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

}
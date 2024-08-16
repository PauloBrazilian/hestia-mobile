package hestia.msStore.domain.dto.in;

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

    private Long listaId;

    @NotNull(message = "The name is null")
    @JsonProperty("name")
    private String listaName;

    @NotNull(message = "The name is null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    private List<ProductDto> products;

    private String personName;
}
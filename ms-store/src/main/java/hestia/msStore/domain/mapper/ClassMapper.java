package hestia.msStore.domain.mapper;

import hestia.msStore.domain.model.Lista;
import hestia.msStore.domain.model.Product;
import hestia.msStore.domain.dto.in.ListaDto;
import hestia.msStore.domain.dto.in.ProductDto;
import hestia.msStore.domain.dto.in.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    ProductDto productToDto(Product product);

    Product dtoToProduct(ProductDto productDto);

    void updateProductToDto(ProductDto productDto, @MappingTarget Product product);

    ProductResponse responseToProduct(Product product);

    Product productToResponse(ProductResponse productResponse);

    ListaDto listaToDto(Lista lista);

    Lista dtoToLista(ListaDto listaDto);

    void updateListaToDto(ListaDto listaDto, @MappingTarget Lista lista);

}
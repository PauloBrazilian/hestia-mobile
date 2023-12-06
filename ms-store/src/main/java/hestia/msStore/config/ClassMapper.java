package hestia.msStore.config;

import hestia.msStore.model.Lista;
import hestia.msStore.model.Product;
import hestia.msStore.payload.ListaDto;
import hestia.msStore.payload.ListaResponse;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.payload.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassMapper {


    ClassMapper INTANCE = Mappers.getMapper(ClassMapper.class);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imgUrl", target = "imgUrl")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "category", target = "categories")
    ProductDto productToDto(Product product);

    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imgUrl", target = "imgUrl")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "categories", target = "category")
    Product dtoToProduct(ProductDto productDto);

   ProductResponse responseToProduct(Product product);

   Product  productToResponse(ProductResponse productResponse);

    ListaDto listaToDto(Lista lista);

    Lista dtoToLista(ListaDto listaDto);

    ListaResponse responseToLista(Lista lista);

    Lista listaToResponse(ListaResponse listaResponse);

}
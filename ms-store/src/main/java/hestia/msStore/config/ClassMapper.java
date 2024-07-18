package hestia.msStore.config;

import hestia.msStore.model.Category;
import hestia.msStore.model.Lista;
import hestia.msStore.model.Product;
import hestia.msStore.payload.CategoryDto;
import hestia.msStore.payload.ListaDto;
import hestia.msStore.payload.ProductDto;
import hestia.msStore.payload.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    ProductDto productToDto(Product product);

    Product dtoToProduct(ProductDto productDto);

    ProductResponse responseToProduct(Product product);

    Product productToResponse(ProductResponse productResponse);

    CategoryDto categoryToDto(Category category);

    Category dtoToCategory(CategoryDto categoryDto);

    ListaDto listaToDto(Lista lista);

    Lista dtoToLista(ListaDto listaDto);

}
package hestia.msStore.exeptions;

import hestia.msStore.model.Product;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private int fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
        super(String.format("%s not found with %s : '%s'",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ResourceNotFoundException(String resourceName) {
        super(resourceName);
    }

//    public ResourceNotFoundException(String product, String name, String productName) {
//        super(String.format("%s not found with %s : '%s'",product,name,productName));
//        this.product = product;
//        this.name = name;
//        this.productName = productName;
//    }
}
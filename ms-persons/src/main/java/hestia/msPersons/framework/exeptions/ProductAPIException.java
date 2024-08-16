package hestia.msPersons.framework.exeptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ProductAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public ProductAPIException(HttpStatus badRequest, String message) {
        this.message = message;
        this.status = status;
    }
}
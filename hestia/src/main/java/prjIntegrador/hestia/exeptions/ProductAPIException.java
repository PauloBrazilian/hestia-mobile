package prjIntegrador.hestia.exeptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ProductAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public ProductAPIException(String message) {
        this.message =message;
        this.status=status;
    }

    public ProductAPIException(HttpStatus status, String message,String message1) {
        super(message);
        this.status = status;
        this.message = message1;

    }
}
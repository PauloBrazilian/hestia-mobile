package hestia.msStore.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ListaNotFoundException extends RuntimeException{

    public ListaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

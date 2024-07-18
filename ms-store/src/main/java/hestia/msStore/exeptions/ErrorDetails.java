package hestia.msStore.exeptions;

import java.util.Date;

public record ErrorDetails(

        Date timestamp,
        String message,
        String details

) { }
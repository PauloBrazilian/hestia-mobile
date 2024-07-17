package hestia.msStore.exeptions;

import lombok.Getter;

import java.util.Date;


public record ErrorDetails(Date timestamp, String message, String details) {
}
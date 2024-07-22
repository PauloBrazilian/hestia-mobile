package hestia.ms_security.domain.enums;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public enum Enum {

    BUSINESS(1L),
    USER(2L);

    Long id;

    Enum(long id) {
        this.id = id;
    }

}

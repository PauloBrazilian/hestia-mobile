package hestia.ms_notification.domain.mapper;

import hestia.ms_notification.domain.dto.EmailDto;
import hestia.ms_notification.domain.model.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    EmailDto emailToDto(Email email);

    Email dtoToEmail(EmailDto emailDto);

}

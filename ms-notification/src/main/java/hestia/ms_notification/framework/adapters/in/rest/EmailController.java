package hestia.ms_notification.framework.adapters.in.rest;

import hestia.ms_notification.application.service.EmailServiceImpl;
import hestia.ms_notification.domain.dto.EmailDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {

    private EmailServiceImpl serviceImpl;

    @PostMapping
    public ResponseEntity<String> emailWelcome(@RequestBody EmailDto emailDto) {
        serviceImpl.emailWelcome(emailDto);
        return new ResponseEntity<>("Send email with Success", HttpStatus.OK);
    }


}

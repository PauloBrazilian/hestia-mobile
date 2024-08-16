package hestia.ms_security.framework.adapaters.in.rest;

import hestia.ms_security.application.service.PersonServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonRoleController {

    private PersonServiceImpl serviceImpl;

    @GetMapping("/person")
    public ResponseEntity<String> getPersons() {
        serviceImpl.getPersons();
        return new ResponseEntity<>("Successfully ", HttpStatus.OK);
    }

    @GetMapping("/business")
    public ResponseEntity<String> getBusiness() {
        serviceImpl.getBusiness();
        return new ResponseEntity<>("Successfully ", HttpStatus.OK);
    }

}
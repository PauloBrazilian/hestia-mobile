package hestia.ms_security.framework.adapaters.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonRoleController {

    @GetMapping
    public ResponseEntity<String> getPerson(){
        return ResponseEntity.ok("Successfully!");
    }

}
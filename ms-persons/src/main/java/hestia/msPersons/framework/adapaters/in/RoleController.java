package hestia.msPersons.framework.adapaters.in;

import hestia.msPersons.application.service.RoleServiceImpl;
import hestia.msPersons.domain.dto.RoleDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private final RoleServiceImpl serviceImpl;

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
        return new ResponseEntity<>(serviceImpl.createRole(roleDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(serviceImpl.findById(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<RoleDto> findByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(serviceImpl.findByEmail(email), HttpStatus.OK);
    }

}

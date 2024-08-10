package hestia.msStore.application.ports.out;

import hestia.msStore.domain.dto.out.RoleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "ms-persons-role", url = "http://localhost:8082/")
public interface RoleClient {

    @PostMapping("/role")
    RoleDto createRole(@RequestBody RoleDto roleDto);

    @GetMapping("/role/{id}")
    RoleDto findById(@PathVariable Long id);

    @GetMapping("/role/email/{email}")
    RoleDto findByEmail(@PathVariable("email") String email);

}

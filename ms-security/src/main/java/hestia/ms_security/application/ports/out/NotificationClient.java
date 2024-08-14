package hestia.ms_security.application.ports.out;

import hestia.ms_security.domain.dto.out.EmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-notification", url = "http://localhost:8084/", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface NotificationClient {

    @PostMapping("/email")
    void emailWelcome(@RequestBody EmailDto emailDto);

}

package hestia.ms_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSecurityApplication.class, args);
	}

}
package hestia.msPersons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsPersonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPersonsApplication.class, args);
	}

}
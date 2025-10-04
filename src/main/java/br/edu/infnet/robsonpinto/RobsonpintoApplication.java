package br.edu.infnet.robsonpinto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RobsonpintoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobsonpintoApplication.class, args);
	}

}

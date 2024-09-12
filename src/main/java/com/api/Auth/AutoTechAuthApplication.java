package com.api.Auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class AutoTechAuthApplication {

	public static void main(String[] args) {
		 // Carregando o .env
		 Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		 dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(AutoTechAuthApplication.class, args);
	}

}

package ru.goryacms.dockerInitializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerInitializrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerInitializrApplication.class, args);
	}

}

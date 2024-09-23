package com.agutierrezl.microservices.config_server;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		// load to file .env
		Dotenv dotenv = Dotenv.load();
		System.setProperty("BRANCH", dotenv.get("BRANCH"));
		// GITHUB
		System.setProperty("GITHUB_USER", dotenv.get("GITHUB_USER"));
		System.setProperty("GITHUB_TOKEN", dotenv.get("GITHUB_TOKEN"));
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}

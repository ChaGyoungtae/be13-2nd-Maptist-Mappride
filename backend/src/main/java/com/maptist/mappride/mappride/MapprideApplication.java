package com.maptist.mappride.mappride;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@SecurityRequirement(name = "bearerAuth")
public class MapprideApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapprideApplication.class, args);
	}

}

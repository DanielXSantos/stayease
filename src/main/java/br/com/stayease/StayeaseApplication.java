package br.com.stayease;

import br.com.stayease.config.StayEasyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "br.com.stayease")
@EnableConfigurationProperties({StayEasyProperties.class})
public class StayeaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StayeaseApplication.class, args);
	}

}

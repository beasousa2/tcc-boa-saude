package br.com.boasaude.associado.microservicecore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MicroserviceCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCoreApplication.class, args);
	}





}



package com.ms_mascotas_eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MsMascotasEventosApplication {
	

	public static void main(String[] args) {
		log.info("Iniciando MsMascotasEventosApplication");
		SpringApplication.run(MsMascotasEventosApplication.class, args);
	}

}

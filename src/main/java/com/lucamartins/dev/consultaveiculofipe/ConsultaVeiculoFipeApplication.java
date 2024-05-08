package com.lucamartins.dev.consultaveiculofipe;

import com.lucamartins.dev.consultaveiculofipe.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaVeiculoFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaVeiculoFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var principal = new Principal();

		principal.startCLIMenu();
	}
}

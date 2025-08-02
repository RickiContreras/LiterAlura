package com.LiterAlura_G8.LiterAlura;

import com.LiterAlura_G8.LiterAlura.principal.Principal;
import com.LiterAlura_G8.LiterAlura.repository.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	private final LibroRepository repository;

	public LiterAluraApplication(LibroRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();

	}
}

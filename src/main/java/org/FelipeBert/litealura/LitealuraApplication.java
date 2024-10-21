package org.FelipeBert.litealura;

import org.FelipeBert.litealura.principal.Principal;
import org.FelipeBert.litealura.repository.AutorRepository;
import org.FelipeBert.litealura.repository.LivroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LitealuraApplication implements CommandLineRunner{

	private LivroRepository livroRepository;
	private AutorRepository autorRepository;

	public LitealuraApplication(LivroRepository livroRepository, AutorRepository autorRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LitealuraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroRepository, autorRepository);
		principal.exibirMenu();
	}
}

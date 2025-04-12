package br.com.fatecweb.fatecweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FatecwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FatecwebApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Senha: " + encoder.encode("123456"));
	}

}

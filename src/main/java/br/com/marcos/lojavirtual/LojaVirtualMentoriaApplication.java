package br.com.marcos.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "br.com.marcos.lojavirtual.model")
@ComponentScan(basePackages = {"br.com.marcos.*"})
@EnableJpaRepositories(basePackages = {"br.com.marcos.lojavirtual.repository"})
@EnableTransactionManagement
public class LojaVirtualMentoriaApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(LojaVirtualMentoriaApplication.class, args);
	}

}

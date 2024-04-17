package br.com.marcos.lojavirtual;

import br.com.marcos.lojavirtual.model.Acesso;
import br.com.marcos.lojavirtual.repository.AcessoRepository;
import br.com.marcos.lojavirtual.service.AcessoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirutalMentoriaApplication.class)
class LojaVirutalMentoriaApplicationTests {


	@Autowired
	private AcessoService service;

	@Autowired
	private AcessoRepository repository;

	@Test
	public void testCadastraAcesso() {

		Acesso acesso = new Acesso();

		acesso.setDescricao("ROLE_ADMIN");

		repository.save(acesso);
	}

}

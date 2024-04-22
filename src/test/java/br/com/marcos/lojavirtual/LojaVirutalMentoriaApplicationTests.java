package br.com.marcos.lojavirtual;

import br.com.marcos.lojavirtual.controller.AcessoController;
import br.com.marcos.lojavirtual.model.Acesso;
import br.com.marcos.lojavirtual.repository.AcessoRepository;
import br.com.marcos.lojavirtual.service.AcessoService;
import junit.framework.TestCase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirutalMentoriaApplication.class)
class LojaVirutalMentoriaApplicationTests extends TestCase{


	@Autowired
	private AcessoController acessoController;


	@Test
	public void testCadastraAcesso() {

		Acesso acesso = new Acesso();

		acesso.setDescricao("ROLE_ADMIN");

		acessoController.salvarAcesso(acesso);
	}

}

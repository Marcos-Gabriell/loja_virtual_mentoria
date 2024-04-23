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

	
	@Autowired
	private AcessoRepository repository;

	@Test
	public void testCadastraAcesso() {

		Acesso acesso = new Acesso();

		acesso.setDescricao("ROLE_ADMIN");

		assertEquals(true, acesso.getId() == null);
		
		acesso = acessoController.salvarAcesso(acesso).getBody();
		
		assertEquals(true, acesso.getId() > 0);
		
		assertEquals("ROLE_ADMIN", acesso.getDescricao());
		
		Acesso acesso2 = repository.findById(acesso.getId()).get();
		
		assertEquals(acesso.getId(), acesso2.getId());
		
		repository.deleteById(acesso2.getId());
		
		repository.flush();
		
		Acesso acesso3 = repository.findById(acesso2.getId()).orElse(null);
		
		assertEquals(true, acesso3 == null);
	}

}

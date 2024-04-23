package br.com.marcos.lojavirtual;

import br.com.marcos.lojavirtual.controller.AcessoController;
import br.com.marcos.lojavirtual.model.Acesso;
import br.com.marcos.lojavirtual.repository.AcessoRepository;
import br.com.marcos.lojavirtual.service.AcessoService;
import junit.framework.TestCase;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = LojaVirutalMentoriaApplication.class)
class LojaVirutalMentoriaApplicationTests extends TestCase{


	@Autowired
	private AcessoController acessoController;

	
	@Autowired
	private AcessoRepository repository;

	
	@Autowired
	private WebApplicationContext wac;
	
	@Test
	public void testeRestApiCadastroAcesso() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_COMPRADOR");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
				                   .perform(MockMvcRequestBuilders.post("/salvarAcesso")
				                   .content(objectMapper.writeValueAsString(acesso))
				                   .accept(MediaType.APPLICATION_JSON)
				                   .contentType(MediaType.APPLICATION_JSON));
		
		
		Acesso objetoRetorno = objectMapper.
				               readValue(retornoApi.andReturn().getResponse().getContentAsString(),
				            		   Acesso.class);
		
		assertEquals(acesso.getDescricao(), objetoRetorno.getDescricao());
 	}
	
	@Test
	public void testeRestApiDeleteAcesso() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_TESTE_DELETE");
		
		acesso = repository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
				                   .perform(MockMvcRequestBuilders.post("/deleteAcesso")
				                   .content(objectMapper.writeValueAsString(acesso))
				                   .accept(MediaType.APPLICATION_JSON)
				                   .contentType(MediaType.APPLICATION_JSON));
		
		assertEquals("Acesso removido", retornoApi.andReturn().getResponse().getContentAsString());
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());

 	}
	
	@Test
	public void testeRestApiDeletePorIdAcesso() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_TESTE_DELETE");
		
		acesso = repository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
				                   .perform(MockMvcRequestBuilders.delete("/deleteAcessoPorId/" + acesso.getId())
				                   .content(objectMapper.writeValueAsString(acesso))
				                   .accept(MediaType.APPLICATION_JSON)
				                   .contentType(MediaType.APPLICATION_JSON));
		
		assertEquals("Acesso removido", retornoApi.andReturn().getResponse().getContentAsString());
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());

 	}
	
	
	@Test
	public void testeRestApiObterAcessoID() throws JsonProcessingException, Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		MockMvc mockMvc = builder.build();
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_TESTE_OBTER_ID");
		
		acesso = repository.save(acesso);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ResultActions retornoApi = mockMvc
				                   .perform(MockMvcRequestBuilders.get("/obterAcesso/" + acesso.getId())
				                   .content(objectMapper.writeValueAsString(acesso))
				                   .accept(MediaType.APPLICATION_JSON)
				                   .contentType(MediaType.APPLICATION_JSON));
		
		assertEquals(200, retornoApi.andReturn().getResponse().getStatus());

		
		Acesso acessoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(), Acesso.class);
 	}
	
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
		
		
		acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ALUNO");
		
		acesso = acessoController.salvarAcesso(acesso).getBody();
		
		List<Acesso> acessos = repository.buscarAcessoDesc("ALUNO".trim().toUpperCase());
		
		assertEquals(1, acessos.size());
		
		repository.deleteById(acesso.getId());
	}

}

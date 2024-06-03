package br.com.marcos.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcos.lojavirtual.model.PessoaJuridica;
import br.com.marcos.lojavirtual.repository.PessoaRepository;
import br.com.marcos.lojavirtual.service.PessoaUserService;

@Profile("test")
@SpringBootTest
@Transactional // Adiciona suporte para transações em testes
public class TestePessoaUsuario {

    @Autowired
    private PessoaUserService pessoaUserService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void testCadPessoaJuridica() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj("865545598956556");
        pessoaJuridica.setNome("Alex Fernando");
        pessoaJuridica.setEmail("alex.fernando.egidio@gmail.com");
        pessoaJuridica.setTelefone("45999795800");
        pessoaJuridica.setInscEstadual("65556565656665");
        pessoaJuridica.setInscMunicipal("55554565656565");
        pessoaJuridica.setNomeFantasia("Nome Fantasia Teste");
        pessoaJuridica.setRazaoSocial("Razão Social Teste");

        pessoaRepository.save(pessoaJuridica);

     
    }
}

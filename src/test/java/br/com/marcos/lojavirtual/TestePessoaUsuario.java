package br.com.marcos.lojavirtual;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import br.com.marcos.lojavirtual.controller.PessoaController;
import br.com.marcos.lojavirtual.model.PessoaJuridica;
import br.com.marcos.lojavirtual.repository.PessoaRepository;
import br.com.marcos.lojavirtual.repository.UsuarioRepository;
import br.com.marcos.lojavirtual.service.PessoaUserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestePessoaUsuario {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaUserService pessoaUserService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvarPj() throws Exception {

        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj("" + Calendar.getInstance().getTimeInMillis());
        pessoaJuridica.setNome("Alex Fernando");
        pessoaJuridica.setEmail("testesalvarpj@gmail.com");
        pessoaJuridica.setTelefone("45999795800");
        pessoaJuridica.setInscEstadual("65556565656665");
        pessoaJuridica.setInscMunicipal("55554565656565");
        pessoaJuridica.setNomeFantasia("54556565665");
        pessoaJuridica.setRazaoSocial("4656656566");

        when(pessoaUserService.salvarPessoaJuridica(any(PessoaJuridica.class))).thenReturn(pessoaJuridica);

        ResponseEntity<PessoaJuridica> response = pessoaController.salvarPj(pessoaJuridica);

        assertNotNull(response);
        assertEquals(pessoaJuridica.getCnpj(), response.getBody().getCnpj());
    }
}

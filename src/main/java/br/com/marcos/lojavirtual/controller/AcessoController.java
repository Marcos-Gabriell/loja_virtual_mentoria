package br.com.marcos.lojavirtual.controller;

import br.com.marcos.lojavirtual.model.Acesso;
import br.com.marcos.lojavirtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AcessoController {

    @Autowired
    private AcessoService service;

    @PutMapping("/salvarAcesso")
    public Acesso salvarAcesso(Acesso acesso) {
        return service.save(acesso);
    }
}

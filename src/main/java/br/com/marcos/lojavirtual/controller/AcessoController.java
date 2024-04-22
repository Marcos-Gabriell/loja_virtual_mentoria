package br.com.marcos.lojavirtual.controller;

import br.com.marcos.lojavirtual.model.Acesso;
import br.com.marcos.lojavirtual.repository.AcessoRepository;
import br.com.marcos.lojavirtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AcessoController {

    @Autowired
    private AcessoService service;
    
    @Autowired
    private AcessoRepository repository;

    @ResponseBody
    @PostMapping(value = "**/salvarAcesso")
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) {
    	
    	Acesso acesoSalvo = service.save(acesso);
    	
    	return new ResponseEntity<Acesso>(acesoSalvo, HttpStatus.OK);
    
    }
    
    @ResponseBody
    @PostMapping(value = "**/deleteAcesso")
    public ResponseEntity<Acesso> deleteAcesso(@RequestBody Acesso acesso) {
    	
    	repository.deleteById(acesso.getId());
    	
    	return new ResponseEntity( HttpStatus.OK);
    
    }
}

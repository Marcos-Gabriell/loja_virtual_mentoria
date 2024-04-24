package br.com.marcos.lojavirtual.controller;

import br.com.marcos.lojavirtual.model.Acesso;
import br.com.marcos.lojavirtual.repository.AcessoRepository;
import br.com.marcos.lojavirtual.service.AcessoService;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity deleteAcesso(@RequestBody Acesso acesso) {
    	
    	repository.deleteById(acesso.getId());
    	
    	return new ResponseEntity("Acesso removido", HttpStatus.OK);
    
    }
    
    @ResponseBody
    @DeleteMapping(value = "**/deleteAcessoPorId/{id}")
    public ResponseEntity deleteAcessoPorId(@PathVariable("id") Long id ) {
    	
    	repository.deleteById(id);
    	
    	return new ResponseEntity("Acesso removido", HttpStatus.OK);
    
    }
    
    @ResponseBody
    @GetMapping(value = "**/obterAcesso/{id}")
    public ResponseEntity<Acesso> obterAcesso(@PathVariable("id") Long id ) {
    	
    	Acesso acesso = repository.findById(id).get();
    	
    	return new ResponseEntity<Acesso>(acesso, HttpStatus.OK);
    
    }
    
    @ResponseBody
    @GetMapping(value = "**/buscarPorDesc/{desc}")
    public ResponseEntity<List<Acesso>> buscarPorDesc(@PathVariable("desc") String desc ) {
    	
    	List<Acesso> acesso = repository.buscarAcessoDesc(desc);
    	
    	return new ResponseEntity<List<Acesso>>(acesso, HttpStatus.OK);
    
    }
}

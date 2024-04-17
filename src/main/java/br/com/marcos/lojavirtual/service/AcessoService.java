package br.com.marcos.lojavirtual.service;

import br.com.marcos.lojavirtual.model.Acesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcos.lojavirtual.repository.AcessoRepository;
@Service

public class AcessoService {

    @Autowired
    private AcessoRepository repository;

    public Acesso save(Acesso acesso) {
        return repository.save(acesso);
    }
}

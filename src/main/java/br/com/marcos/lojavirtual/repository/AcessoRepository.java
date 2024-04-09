package br.com.marcos.lojavirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcos.lojavirtual.model.Acesso;

@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long>{

}

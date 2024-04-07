package br.com.marcos.lojavirtual.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa{

    @Column(nullable = false)
	private String cnpj;
	
    @Column(nullable = false)
	private String inscEstadual;
	
	private String inscMunicipla;
	
    @Column(nullable = false)
	private String nomeFansia;
	
    @Column(nullable = false)
	private String razaoSocial;
	
	private String categoria;
}

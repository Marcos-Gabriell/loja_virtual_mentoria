package br.com.marcos.lojavirtual.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa{

	private String cnpj;
	
	private String inscEstadual;
	
	private String inscMunicipla;
	
	private String nomeFansia;
	
	private String razaoSocial;
	
	
}

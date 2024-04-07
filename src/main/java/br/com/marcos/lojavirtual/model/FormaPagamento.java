package br.com.marcos.lojavirtual.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "forma_pagamento")
@SequenceGenerator(name = "seq_form_pagamento", sequenceName = "seq_form_pagamento", allocationSize = 1, initialValue = 1)
public class FormaPagamento implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_form_pagamento")
	private Long id;
	
    @Column(nullable = false)
	private String descricao;
}

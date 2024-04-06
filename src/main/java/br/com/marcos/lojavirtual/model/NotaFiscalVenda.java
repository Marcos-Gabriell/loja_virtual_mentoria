package br.com.marcos.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "nota_fiscal_venda")
@SequenceGenerator(name = "seq_nota_fiscal_venda", sequenceName = "seq_nota_fiscal_venda", allocationSize = 1, initialValue = 1)
public class NotaFiscalVenda implements Serializable{

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nota_fiscal_venda")
	@Id
	private Long id;
	
	private String numeroNota;
	
	private String serie;
	
	private String tipo;
	
	@Column(columnDefinition = "text")
	private String xml;
	
	@Column(columnDefinition = "text")
	private String pdf;
	
}

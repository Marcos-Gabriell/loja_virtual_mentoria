package br.com.marcos.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable{

	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	@Id
	private Long id;
	
	private String tipoUnidade;
	
	private String nome;
	
	private Boolean ativo = Boolean.TRUE;
	
	@Column(columnDefinition = "text", length = 2000)
	private String descricao;
	
	
	/** NOTA ITEM PRODUTO+ **/
	
	private Double peso;
	
	private Double largura;
	
	private Double altura;
	
	private Double profundidade;
	
	private BigDecimal valorVenda = BigDecimal.ZERO;
	
	private Integer QtdEtoque = 0;
	
	private Integer QtdAlertaEstoque = 0;
	
	private String linkYOuTube;
	
	private Boolean  alertaQtdEstoque = Boolean.FALSE;
	
	private Integer QqtdClique = 0;
}

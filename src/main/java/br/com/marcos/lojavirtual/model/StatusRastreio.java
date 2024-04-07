package br.com.marcos.lojavirtual.model;

import java.io.Serializable;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "status_rastreio")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_status_rastreio", allocationSize = 1, initialValue = 1)
public class StatusRastreio implements Serializable{

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_rastreio")
	@Id
	private Long id;
	
	private String centroDestribuicao;
	
	private String cidade;
	
	private String estado;
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "venda_compra_loja_virt_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_compra_loja_virt_fk"))
	private VendaCompraLojaVirtual vendaCompraLojaVirtual;
	
}

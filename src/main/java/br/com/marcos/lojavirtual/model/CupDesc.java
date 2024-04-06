package br.com.marcos.lojavirtual.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "cup_desc")
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", allocationSize = 1, initialValue = 1)
public class CupDesc implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_descr")
	private Long id;
	
	private String codDesc;
	
	private BigDecimal valorRealDesc;
	
	private BigDecimal valorPocentDesc;
	
	@Temporal(TemporalType.DATE)
	private Date dataValidadeCupom;
}

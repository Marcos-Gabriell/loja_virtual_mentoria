package br.com.marcos.lojavirtual.model.dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ObjectErroDTO implements Serializable{
	
	private String error;
	
	private String code;

}

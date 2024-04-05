package br.com.marcos.lojavirtual.enums;

import lombok.Getter;

@Getter
public enum StatusContaReceber {

	
	CONBRANCA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	QUITADA("Quitada");
	
	private String descricao;
	
	StatusContaReceber(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
}

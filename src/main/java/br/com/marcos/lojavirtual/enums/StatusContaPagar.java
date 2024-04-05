package br.com.marcos.lojavirtual.enums;

import lombok.Getter;

@Getter
public enum StatusContaPagar {

	
	CONBRANCA("Pagar"),
	VENCIDA("Vencida"),
	ABERTA("Aberta"),
	RENEGOCIADA("Renegociada"),
	QUITADA("Quitada");
	
	private String descricao;
	
	StatusContaPagar(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
}

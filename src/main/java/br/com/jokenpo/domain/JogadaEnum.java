package br.com.jokenpo.domain;

public enum JogadaEnum {
	
	PEDRA ("PEDRA"),
	
	PAPEL ("PAPEL"),
	
	TESOURA("TESOURA");
	
	private String descricao;
	
	JogadaEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

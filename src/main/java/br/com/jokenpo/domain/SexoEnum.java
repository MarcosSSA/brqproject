package br.com.jokenpo.domain;

public enum SexoEnum {
	
	MASCULINO ("Masculino"),
	
	FEMININO ("Feminino");
	
	private String descricao;
	
	private SexoEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

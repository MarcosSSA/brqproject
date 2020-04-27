package br.com.jokenpo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.jokenpo.domain.JogadaEnum;

@Entity
public class Jogada {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
	private Jogador jogador;
	
	@JsonInclude(Include.NON_NULL)
	private JogadaEnum jogada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public Jogador getIdJogador() {
		return jogador;
	}

	public void setIdJogador(Jogador idJogador) {
		this.jogador = idJogador;
	}

	public JogadaEnum getJogada() {
		return jogada;
	}

	public void setJogada(JogadaEnum jogada) {
		this.jogada = jogada;
	}

}

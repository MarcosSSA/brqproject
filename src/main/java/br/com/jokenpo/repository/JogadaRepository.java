package br.com.jokenpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jokenpo.model.Jogada;

public interface JogadaRepository extends JpaRepository<Jogada, Long>{
	
	Jogada findByJogadorId (Long jogador);

}

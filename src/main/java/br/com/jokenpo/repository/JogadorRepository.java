package br.com.jokenpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jokenpo.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long>{

}

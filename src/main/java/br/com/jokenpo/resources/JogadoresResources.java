package br.com.jokenpo.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jokenpo.domain.JogadaEnum;
import br.com.jokenpo.model.Jogada;
import br.com.jokenpo.model.Jogador;
import br.com.jokenpo.repository.JogadaRepository;
import br.com.jokenpo.repository.JogadorRepository;

@RestController
@RequestMapping("/jogadores")
public class JogadoresResources {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private JogadaRepository jogadaRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Jogador> listar() {
		return jogadorRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Jogador jogador) {
		jogadorRepository.save(jogador);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Jogador buscar(@PathVariable("id") Long id) {
		return jogadorRepository.findById(id).get();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable("id") Long id) {
		jogadorRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void atualizar(@RequestBody Jogador jogador, @PathVariable("id") Long id) {
		jogador.setId(id);
		jogadorRepository.save(jogador);
	}
	
	@RequestMapping(value = "/{idJogador}/{jogada}", method = RequestMethod.POST)
	public void parametrizarJogada(@PathVariable Long idJogador, @PathVariable JogadaEnum jogada) {
		Jogador jogador = this.buscar(idJogador);
		Jogada lance = new Jogada();
		lance.setIdJogador(jogador);
		lance.setJogada(jogada);
		jogadaRepository.save(lance);
	}
	
	@RequestMapping(value = "/{jogadores}", method = RequestMethod.GET)
	public String jogar(@PathVariable List<Long> jogadores) {
		String resultado = null;
		if(jogadores.size() < 4 && jogadores.size() > 1) {
			List<Jogador> participantes = jogadorRepository.findAllById(jogadores);
			for (Jogador jogador : participantes) {
				lance = jogadaRepository.findByJogadorId(jogador.getId()).getJogada()); 	
			}			
			
		}else {
			resultado = "Números de jogadores incompatível";
		}
		return resultado;
	}
}

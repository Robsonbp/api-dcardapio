package br.edu.infnet.robsonpinto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.robsonpinto.model.domain.GrupoOpcao;
import br.edu.infnet.robsonpinto.model.service.GrupoOpcaoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/grupos-opcao")
public class GrupoOpcaoController {
	
	private final GrupoOpcaoService grupoOpcaoService;
	
	public GrupoOpcaoController(GrupoOpcaoService grupoOpcaoService) {
		this.grupoOpcaoService = grupoOpcaoService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GrupoOpcao> buscar(@PathVariable Integer id) {
		
		GrupoOpcao opcao = grupoOpcaoService.buscar(id);
		
		return ResponseEntity.ok(opcao);
	}
	
	@GetMapping()
	public ResponseEntity<List<GrupoOpcao>> buscarLista() {
		
		List<GrupoOpcao> opcoes = grupoOpcaoService.buscarLista();
		
		if (opcoes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(opcoes);
	}
	
	@PostMapping
	public ResponseEntity<GrupoOpcao> criar(@Valid @RequestBody GrupoOpcao grupoOpcao) {
		
		GrupoOpcao novoGrupoOpcao = grupoOpcaoService.criar(grupoOpcao);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoGrupoOpcao);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<GrupoOpcao> alterar(@PathVariable Integer id, @RequestBody GrupoOpcao grupoOpcao) {
		
		GrupoOpcao grupoOpcaoAlterado = grupoOpcaoService.alterar(id, grupoOpcao);
		return ResponseEntity.ok(grupoOpcaoAlterado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		grupoOpcaoService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}

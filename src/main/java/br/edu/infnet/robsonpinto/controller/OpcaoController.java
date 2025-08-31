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

import br.edu.infnet.robsonpinto.model.domain.Opcao;
import br.edu.infnet.robsonpinto.model.service.OpcaoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/opcoes")
public class OpcaoController {
	
	private final OpcaoService opcaoService;
	
	public OpcaoController(OpcaoService opcaoService) {
		this.opcaoService = opcaoService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Opcao> buscar(@PathVariable Integer id) {
		
		Opcao opcao = opcaoService.buscar(id);
		
		return ResponseEntity.ok(opcao);
	}
	
	@GetMapping()
	public ResponseEntity<List<Opcao>> buscarLista() {
		
		List<Opcao> opcoes = opcaoService.buscarLista();
		
		if (opcoes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(opcoes);
	}
	
	@PostMapping
	public ResponseEntity<Opcao> criar(@Valid @RequestBody Opcao opcao) {
		
		Opcao novaOpcao = opcaoService.criar(opcao);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaOpcao);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Opcao> alterar(@PathVariable Integer id, @RequestBody Opcao opcao) {
		
		Opcao opcaoAlterada = opcaoService.alterar(id, opcao);
		return ResponseEntity.ok(opcaoAlterada);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		opcaoService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}

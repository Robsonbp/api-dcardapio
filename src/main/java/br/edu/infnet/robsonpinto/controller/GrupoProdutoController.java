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

import br.edu.infnet.robsonpinto.model.dto.GrupoProdutoOutputDto;
import br.edu.infnet.robsonpinto.model.dto.GrupoProdutoRequestDto;
import br.edu.infnet.robsonpinto.model.service.GrupoProdutoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/grupos-produto")
public class GrupoProdutoController {
	
	private final GrupoProdutoService grupoProdutoService;
	
	public GrupoProdutoController(GrupoProdutoService grupoProdutoService) {
		this.grupoProdutoService = grupoProdutoService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GrupoProdutoOutputDto> buscar(@PathVariable Integer id) {
		
		GrupoProdutoOutputDto produto = grupoProdutoService.buscar(id);
		
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping()
	public ResponseEntity<List<GrupoProdutoOutputDto>> buscarLista() {
		
		List<GrupoProdutoOutputDto> produtos = grupoProdutoService.buscarLista();
		
		if (produtos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(produtos);
	}
	
	@PostMapping
	public ResponseEntity<GrupoProdutoOutputDto> criar(@Valid @RequestBody GrupoProdutoRequestDto grupoProduto) {
		
		GrupoProdutoOutputDto novoGrupoProduto = grupoProdutoService.criar(grupoProduto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoGrupoProduto);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<GrupoProdutoOutputDto> alterar(@PathVariable Integer id, @RequestBody GrupoProdutoRequestDto grupoProduto) {
		
		GrupoProdutoOutputDto grupoProdutoAlterado = grupoProdutoService.alterar(id, grupoProduto);
		return ResponseEntity.ok(grupoProdutoAlterado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		grupoProdutoService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}

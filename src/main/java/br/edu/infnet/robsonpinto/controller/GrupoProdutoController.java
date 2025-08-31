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

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;
import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoProdutoInvalidoException;
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
	public ResponseEntity<GrupoProduto> buscar(@PathVariable Integer id) {
		
		GrupoProduto produto = grupoProdutoService.buscar(id);
		
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping()
	public ResponseEntity<List<GrupoProduto>> buscarLista() {
		
		List<GrupoProduto> produtos = grupoProdutoService.buscarLista();
		
		if (produtos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(produtos);
	}
	
	@PostMapping
	public ResponseEntity<GrupoProduto> criar(@Valid @RequestBody GrupoProduto grupoProduto) {
		
		try {
			GrupoProduto novoGrupoProduto = grupoProdutoService.criar(grupoProduto);
			return ResponseEntity.status(HttpStatus.CREATED).body(novoGrupoProduto);
		
		} catch (GrupoProdutoInvalidoException e) {
			return ResponseEntity.badRequest().build();
		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<GrupoProduto> alterar(@PathVariable Integer id, @RequestBody GrupoProduto grupoProduto) {
		
		GrupoProduto grupoProdutoAlterado = grupoProdutoService.alterar(id, grupoProduto);
		return ResponseEntity.ok(grupoProdutoAlterado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		grupoProdutoService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}

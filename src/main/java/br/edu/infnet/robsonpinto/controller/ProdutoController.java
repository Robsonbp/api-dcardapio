package br.edu.infnet.robsonpinto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.robsonpinto.model.dto.ProdutoOutputDto;
import br.edu.infnet.robsonpinto.model.dto.ProdutoRequestDto;
import br.edu.infnet.robsonpinto.model.service.ProdutoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoOutputDto> buscar(@PathVariable Integer id) {
		
		ProdutoOutputDto produto = produtoService.buscar(id);
		
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping()
	public ResponseEntity<List<ProdutoOutputDto>> buscarLista() {
		
		List<ProdutoOutputDto> produtos = produtoService.buscarLista();
		
		if (produtos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(produtos);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoOutputDto> criar(@Valid @RequestBody ProdutoRequestDto produto) {
		
		ProdutoOutputDto novoProduto = produtoService.criar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoOutputDto> alterar(@PathVariable Integer id, @RequestBody ProdutoRequestDto produto) {
		
		ProdutoOutputDto produtoAlterado = produtoService.alterar(id, produto);
		return ResponseEntity.ok(produtoAlterado);
	}
	
	@PatchMapping(value = "/{id}/inativar")
	public ResponseEntity<ProdutoOutputDto> inativar(@PathVariable Integer id) {
		ProdutoOutputDto produto = produtoService.inativar(id);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		produtoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}

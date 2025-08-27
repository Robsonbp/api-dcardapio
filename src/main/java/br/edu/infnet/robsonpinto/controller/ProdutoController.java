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

import br.edu.infnet.robsonpinto.model.domain.Produto;
import br.edu.infnet.robsonpinto.model.service.ProdutoService;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping(value = "/{id}")
	public Produto buscar(@PathVariable Integer id) {
		return produtoService.buscar(id);
	}
	
	@GetMapping()
	public ResponseEntity<List<Produto>> buscarLista() {
		
		List<Produto> produtos = produtoService.buscarLista();
		
		if (produtos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(produtos);
	}
	
	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
		
		Produto novoProduto = produtoService.criar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	}
	
	@PutMapping(value = "/{id}")
	public Produto alterar(@PathVariable Integer id, @RequestBody Produto produto) {
		return produtoService.alterar(id, produto);
	}
	
	@PatchMapping(value = "/{id}/inativar")
	public Produto inativar(@PathVariable Integer id) {
		return produtoService.inativar(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		produtoService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}

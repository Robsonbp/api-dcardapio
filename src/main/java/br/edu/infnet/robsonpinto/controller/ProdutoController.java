package br.edu.infnet.robsonpinto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Produto buscarProduto(@PathVariable Integer id) {
		return produtoService.buscar(id);
	}
	
	@GetMapping()
	public List<Produto> buscarProdutos() {
		return produtoService.buscarLista();
	}
}

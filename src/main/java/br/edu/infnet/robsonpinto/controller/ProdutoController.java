package br.edu.infnet.robsonpinto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.robsonpinto.model.domain.Produto;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@GetMapping
	public Produto pegarProduto() {
		Produto produto = new Produto();
		
		produto.nome = "Doce";
		produto.descricao = "Doce muito gostoso.";
		produto.valor = 20.00;
		produto.ativo = true;
		
		return produto;
	}
	
	@GetMapping("/nome")
	public String pegarNome() {
		return "Doce";
	}
	
	@GetMapping("/descricao")
	public String pegarDescricao() {
		return "Doce muito gostoso.";
	}
	
	@GetMapping("/valor")
	public double pegarValor() {
		return 20.00;
	}
	
	@GetMapping("/ativo")
	public boolean pegarAtivo() {
		return true;
	}
}

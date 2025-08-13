package br.edu.infnet.robsonpinto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.robsonpinto.model.domain.Produto;

@RestController
@RequestMapping("/api/produtos")
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
}

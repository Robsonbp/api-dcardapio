package br.edu.infnet.robsonpinto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	@GetMapping("/api/produto/nome")
	public String pegarNome() {
		return "Doce";
	}
}

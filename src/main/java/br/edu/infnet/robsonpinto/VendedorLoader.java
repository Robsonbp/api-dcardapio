package br.edu.infnet.robsonpinto;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.robsonpinto.model.domain.Produto;

@Component
public class VendedorLoader implements ApplicationRunner {
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Produto produto = new Produto();
		
		produto.nome = "Doce";
		produto.descricao = "Doce muito gostoso";
		produto.valor = 20.0;
		produto.ativo = true;
		
		System.out.println(produto);
		
	}
}

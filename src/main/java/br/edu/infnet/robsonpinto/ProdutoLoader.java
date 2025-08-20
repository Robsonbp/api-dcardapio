package br.edu.infnet.robsonpinto;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;
import br.edu.infnet.robsonpinto.model.domain.Produto;
import br.edu.infnet.robsonpinto.model.service.ProdutoService;

@Component
public class ProdutoLoader implements ApplicationRunner {
	
	private final ProdutoService produtoService;
	
	public ProdutoLoader(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader arquivo = new FileReader("produto.txt");
		BufferedReader leitura = new BufferedReader(arquivo);
		
		String[] campos = null;
		
		String linha = leitura.readLine();
		while(linha != null) {
			campos = linha.split(";");
			
			Produto produto = new Produto();
			GrupoProduto grupoProduto = new GrupoProduto();
			
			produto.setId(Integer.valueOf(campos[0]));
			produto.setNome(campos[1]);
			produto.setDescricao(campos[2]);
			produto.setValor(Double.valueOf(campos[3]));
			produto.setAtivo(Boolean.valueOf(campos[4]));
			produto.setGrupoProduto(grupoProduto);
			
			grupoProduto.setId(Integer.valueOf(campos[5]));
			grupoProduto.setNome(campos[6]);
			grupoProduto.setOrdemExibicao(Integer.valueOf(campos[7]));
			grupoProduto.setAtivo(Boolean.valueOf(campos[8]));
			
			System.out.println(produto);
			produtoService.criar(produto);
			
			linha = leitura.readLine();
		}
		
		System.out.println(produtoService.buscarLista().size());
		leitura.close();
	}
}

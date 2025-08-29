package br.edu.infnet.robsonpinto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;
import br.edu.infnet.robsonpinto.model.domain.Produto;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoInvalidoException;
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
			
			produto.setNome(campos[0]);
			produto.setDescricao(campos[1]);
			produto.setValor(Double.valueOf(campos[2]));
			produto.setAtivo(Boolean.valueOf(campos[3]));
			produto.setGrupoProduto(grupoProduto);
			
			grupoProduto.setNome(campos[4]);
			grupoProduto.setOrdemExibicao(Integer.valueOf(campos[5]));
			grupoProduto.setAtivo(Boolean.valueOf(campos[6]));
			
			
			try {
				produtoService.criar(produto);
			} catch (ProdutoInvalidoException e) {
				System.err.println("Erro na inclusão: " + e.getMessage());
			}
			
			//System.out.println(produtoCriado);
			
			linha = leitura.readLine();
		}
		
		List<Produto> produtos = produtoService.buscarLista();
		produtos.forEach(System.out::println);

		leitura.close();
	}
}

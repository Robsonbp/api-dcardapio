package br.edu.infnet.robsonpinto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;
import br.edu.infnet.robsonpinto.model.domain.Produto;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoInvalidoException;
import br.edu.infnet.robsonpinto.model.service.GrupoProdutoService;
import br.edu.infnet.robsonpinto.model.service.ProdutoService;
import jakarta.transaction.Transactional;

@Order(2)
@Transactional
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	private final ProdutoService produtoService;
	private final GrupoProdutoService grupoProdutoService;
	
	public ProdutoLoader(ProdutoService produtoService, GrupoProdutoService grupoProdutoService) {
		this.produtoService = produtoService;
		this.grupoProdutoService = grupoProdutoService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader arquivo = new FileReader("produto.txt");
		BufferedReader leitura = new BufferedReader(arquivo);
		
		String[] campos = null;
		
		String linha = leitura.readLine();
		
		while(linha != null) {
			campos = linha.split(";");
			
			String nome = campos[0];
			String descricao = campos[1];
			BigDecimal valor = new BigDecimal(campos[2]);
			Boolean ativo = Boolean.valueOf(campos[3]);
			Integer idGrupo = Integer.valueOf(campos[4]);
			
			GrupoProduto grupoProduto = null;
			
			try {
				grupoProduto = grupoProdutoService.buscar(idGrupo);
				if (grupoProduto == null) {
					System.err.println("O produto " + nome + " não pode ser cadastrado, pois o grupo de produto com id " + idGrupo + " não foi encontrado.");
					linha = leitura.readLine();
					continue;
				}
			} catch (Exception e) {
				linha = leitura.readLine();
				continue;
			}
			
			Produto produto = new Produto();
			
			produto.setNome(nome);
			produto.setDescricao(descricao);
			produto.setValor(valor);
			produto.setAtivo(ativo);
			produto.setGrupoProduto(grupoProduto);
			
			
			try {
				produtoService.criar(produto);
			} catch (ProdutoInvalidoException e) {
				System.err.println("Erro na inclusão do produto " + nome + ". Erro: " + e.getMessage());
			}
						
			linha = leitura.readLine();
		}
		
		List<Produto> produtos = produtoService.buscarLista();
		produtos.forEach(System.out::println);

		leitura.close();
	}
}

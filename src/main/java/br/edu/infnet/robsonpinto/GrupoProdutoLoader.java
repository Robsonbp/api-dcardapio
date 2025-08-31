package br.edu.infnet.robsonpinto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;
import br.edu.infnet.robsonpinto.model.service.GrupoProdutoService;
import jakarta.transaction.Transactional;

@Order(1)
@Transactional
@Component
public class GrupoProdutoLoader implements ApplicationRunner {
	
	private final GrupoProdutoService grupoProdutoService;
	
	public GrupoProdutoLoader(GrupoProdutoService grupoProdutoService) {
		this.grupoProdutoService = grupoProdutoService;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader arquivo = new FileReader("grupoProduto.txt");
		BufferedReader leitura = new BufferedReader(arquivo);
		
		String[] campos = null;
		String linha = leitura.readLine();
		
		while(linha != null) {
			campos = linha.split(";");
			
			GrupoProduto grupoProduto = new GrupoProduto();
			
			grupoProduto.setNome(campos[0]);
			grupoProduto.setOrdemExibicao(Integer.valueOf(campos[1]));
			grupoProduto.setAtivo(Boolean.valueOf(campos[2]));	
			
			try {
				grupoProdutoService.criar(grupoProduto);
			} catch (Exception e) {
				System.err.println("Erro na inclusão de grupo de produto " + e.getMessage());
			}
			
			linha = leitura.readLine();
		}
		
		List<GrupoProduto> gruposProduto = grupoProdutoService.buscarLista();
		gruposProduto.forEach(System.out::println);

		leitura.close();
	}
}

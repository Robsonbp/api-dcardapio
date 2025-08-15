package br.edu.infnet.robsonpinto;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.robsonpinto.model.domain.Produto;

@Component
public class ProdutoLoader implements ApplicationRunner {
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader arquivo = new FileReader("produto.txt");
		BufferedReader leitura = new BufferedReader(arquivo);
		
		String[] campos = null;
		
		String linha = leitura.readLine();
		while(linha != null) {
			campos = linha.split(";");
			
			Produto produto = new Produto();
			produto.setId(Integer.valueOf(campos[0]));
			produto.setNome(campos[1]);
			produto.setDescricao(campos[2]);
			produto.setValor(Double.valueOf(campos[3]));
			produto.setAtivo(Boolean.valueOf(campos[4]));
			
			System.out.println(produto);
			linha = leitura.readLine();
		}
		
		leitura.close();
	}
}

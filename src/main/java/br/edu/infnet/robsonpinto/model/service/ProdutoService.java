package br.edu.infnet.robsonpinto.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.domain.Produto;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoInvalidoException;

@Service
public class ProdutoService implements CrudService<Produto, Integer> {
	
	private final Map<Integer, Produto> mapa = new ConcurrentHashMap<Integer, Produto>();
	private final AtomicInteger nextId = new AtomicInteger(1);
	
	@Override
	public Produto criar(Produto produto) {
		
		if (produto.getNome() == null) {
			throw new ProdutoInvalidoException("O nome do produto é inválido.");
		}
		
		produto.setId(nextId.getAndIncrement());
		mapa.put(produto.getId(), produto);
		
		return produto;
	}

	@Override
	public Produto buscar(Integer id) {
		
		Produto produto = mapa.get(id);
		
		if (produto == null) {
			throw new IllegalArgumentException("Não é possível obter o produto pelo id" + id);
		}
		
		
		//Produto produto = new Produto();
		//produto.setId(1);
		//produto.setNome("Doce");
		//produto.setDescricao("Doce muito gostoso.");
		//produto.setValor(20.00);
		//produto.setAtivo(true);
		
		return produto;
	}

	@Override
	public void excluir(Integer id) {
		mapa.remove(id);
		
	}

	@Override
	public List<Produto> buscarLista() {
		return new ArrayList<Produto>(mapa.values());
	}

}

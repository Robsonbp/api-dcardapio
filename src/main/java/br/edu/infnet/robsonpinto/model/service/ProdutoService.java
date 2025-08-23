package br.edu.infnet.robsonpinto.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.domain.Produto;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoInvalidoException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoNaoEncontradoException;

@Service
public class ProdutoService implements CrudService<Produto, Integer> {
	
	private final Map<Integer, Produto> mapa = new ConcurrentHashMap<Integer, Produto>();
	private final AtomicInteger nextId = new AtomicInteger(1);
	
	private void validar(Produto produto) {
		if (produto == null) {
			throw new IllegalArgumentException("O produto não pode estar nulo.");
		}
		
		if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
			throw new ProdutoInvalidoException("O nome do produto é inválido.");
		}
	}
	
	@Override
	public Produto criar(Produto produto) {
		
		validar(produto);
		
		if (produto.getId() != null && produto.getId() != 0) {
			throw new IllegalArgumentException("Um novo produto não pode ter um id.");
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
		
		return produto;
	}

	@Override
	public void excluir(Integer id) {
		
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para exclusão de um produto.");
		}
		
		if (!mapa.containsKey(id)) {
			throw new ProdutoNaoEncontradoException("O produto com o id " + id + " não foi encontrado.");
		}
		
		mapa.remove(id);
	}

	@Override
	public List<Produto> buscarLista() {
		return new ArrayList<Produto>(mapa.values());
	}

	@Override
	public Produto alterar(Integer id, Produto produto) {
		
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para alteração de um produto.");
		}
		
		validar(produto);
		
		buscar(id);
		produto.setId(id);
		
		mapa.put(produto.getId(), produto);
		
		return produto;
	}
	
	public Produto inativar(Integer id) {
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para inativação de um produto.");
		}
		
		Produto produto = buscar(id);
		
		if(!produto.isAtivo()) {
			System.out.println("O produto" + produto.getNome() + "já está desativado");
			return produto;
		}
		
		produto.setAtivo(false);
		mapa.put(id, produto);
		
		return produto;
		
		
	}

}

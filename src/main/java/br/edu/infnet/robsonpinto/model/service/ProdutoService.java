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
import br.edu.infnet.robsonpinto.model.repository.ProdutoRepository;

@Service
public class ProdutoService implements CrudService<Produto, Integer> {
	
	private final ProdutoRepository produtoRepository;
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
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
		
		return produtoRepository.save(produto);
	}

	@Override
	public Produto buscar(Integer id) {
		
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("É necessário passar um id para exclusão de um produto.");
		}
		
		return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException("O produto com o id " + id + " não existe."));
	}

	@Override
	public void excluir(Integer id) {
		
		Produto produto = buscar(id);
		produtoRepository.delete(produto);
		
	}

	@Override
	public List<Produto> buscarLista() {
		return produtoRepository.findAll();
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

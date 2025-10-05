package br.edu.infnet.robsonpinto.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;
import br.edu.infnet.robsonpinto.model.domain.Produto;
import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoProdutoInvalidoException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoInvalidoException;
import br.edu.infnet.robsonpinto.model.domain.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.robsonpinto.model.dto.ProdutoOutputDto;
import br.edu.infnet.robsonpinto.model.dto.ProdutoRequestDto;
import br.edu.infnet.robsonpinto.model.repository.GrupoProdutoRepository;
import br.edu.infnet.robsonpinto.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	private final GrupoProdutoRepository grupoProdutoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository, GrupoProdutoRepository grupoProdutoRepository) {
		this.produtoRepository = produtoRepository;
		this.grupoProdutoRepository = grupoProdutoRepository;
	}
	
	private void validar(ProdutoRequestDto produto) {
		if (produto == null) {
			throw new IllegalArgumentException("O produto não pode estar nulo.");
		}
		
		if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
			throw new ProdutoInvalidoException("O nome do produto é inválido.");
		}
	}
	
	@Transactional
	public ProdutoOutputDto criar(ProdutoRequestDto produtoEntrada) {
		
		validar(produtoEntrada);
		
		GrupoProduto grupoProduto = grupoProdutoRepository.findById(produtoEntrada.getGrupoProdutoId()).orElseThrow(() -> new GrupoProdutoInvalidoException("Grupo produto vinculado não existe."));
		
		Produto produto = new Produto();
		produto.setNome(produtoEntrada.getNome());
		produto.setDescricao(produtoEntrada.getDescricao());
		produto.setValor(produtoEntrada.getValor());
		produto.setAtivo(produtoEntrada.isAtivo());
		produto.setGrupoProduto(grupoProduto);
		
		
		Produto produtoCriado = produtoRepository.save(produto);		
		
		return new ProdutoOutputDto(produtoCriado);
	}

	public ProdutoOutputDto buscar(Integer id) {
		
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("É necessário passar um id para exclusão de um produto.");
		}
		
		Produto produtoBuscado = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException("O produto com o id " + id + " não existe."));
		
		return new ProdutoOutputDto(produtoBuscado);
	}

	@Transactional
	public void excluir(Integer id) {
		
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException("O produto com o id " + id + " não existe."));
		produtoRepository.delete(produto);
		
	}

	public List<ProdutoOutputDto> buscarLista() {
		
		List<Produto> produtos = produtoRepository.findAll();
		
		return produtos.stream().map(ProdutoOutputDto::new).toList();
	}

	@Transactional
	public ProdutoOutputDto alterar(Integer id, ProdutoRequestDto produtoEntrada) {
		
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para alteração de um produto.");
		}
		
		validar(produtoEntrada);
		GrupoProduto grupoProduto = grupoProdutoRepository.findById(produtoEntrada.getGrupoProdutoId()).orElseThrow(() -> new GrupoProdutoInvalidoException("Grupo produto vinculado não existe."));
		
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException("O produto com o id " + id + " não existe."));
		produto.setNome(produtoEntrada.getNome());
		produto.setDescricao(produtoEntrada.getDescricao());
		produto.setValor(produtoEntrada.getValor());
		produto.setAtivo(produtoEntrada.isAtivo());
		produto.setGrupoProduto(grupoProduto);
		
		Produto produtoAtualizado = produtoRepository.save(produto);
		
		return new ProdutoOutputDto(produtoAtualizado);
	}
	
	@Transactional
	public ProdutoOutputDto inativar(Integer id) {
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para inativação de um produto.");
		}
		
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException("O produto com o id " + id + " não existe."));
		
		if(!produto.isAtivo()) {
			return new ProdutoOutputDto(produto);
		}
		
		produto.setAtivo(false);
		Produto produtoInativado = produtoRepository.save(produto);
		
		return new ProdutoOutputDto(produtoInativado);
	}

}

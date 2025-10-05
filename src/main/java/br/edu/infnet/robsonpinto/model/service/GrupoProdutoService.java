package br.edu.infnet.robsonpinto.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;
import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoProdutoNaoEncontradoException;
import br.edu.infnet.robsonpinto.model.dto.GrupoProdutoOutputDto;
import br.edu.infnet.robsonpinto.model.dto.GrupoProdutoRequestDto;
import br.edu.infnet.robsonpinto.model.repository.GrupoProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class GrupoProdutoService {
	
	private final GrupoProdutoRepository grupoProdutoRepository;
	public GrupoProdutoService(GrupoProdutoRepository grupoProdutoRepository) {
		this.grupoProdutoRepository = grupoProdutoRepository;
	}
	
	@Transactional
	public GrupoProdutoOutputDto buscar(Integer id) {
		
		GrupoProduto grupoProduto = grupoProdutoRepository.findById(id).orElseThrow(() -> new GrupoProdutoNaoEncontradoException("O grupo de produto com o id " + id + " não existe."));
		return new GrupoProdutoOutputDto(grupoProduto);
	}

	@Transactional
	public List<GrupoProdutoOutputDto> buscarLista() {
		
		List<GrupoProduto> gruposProduto = grupoProdutoRepository.findAll();
		return gruposProduto.stream().map(GrupoProdutoOutputDto::new).toList();
	}

	@Transactional
	public GrupoProdutoOutputDto criar(GrupoProdutoRequestDto grupoProdutoEntrada) {
		
		GrupoProduto grupoProduto = new GrupoProduto();
		grupoProduto.setNome(grupoProdutoEntrada.getNome());
		grupoProduto.setOrdemExibicao(grupoProdutoEntrada.getOrdemExibicao());
		grupoProduto.setAtivo(grupoProdutoEntrada.isAtivo());
		
		GrupoProduto grupoProdutoCriado = grupoProdutoRepository.save(grupoProduto);
		return new GrupoProdutoOutputDto(grupoProdutoCriado);
	}

	@Transactional
	public GrupoProdutoOutputDto alterar(Integer id, GrupoProdutoRequestDto grupoProdutoEntrada) {
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para alteração de um grupo de produto.");
		}
		
		GrupoProduto grupoProduto = grupoProdutoRepository.findById(id).orElseThrow(() -> new GrupoProdutoNaoEncontradoException("O grupo de produto com o id " + id + " não existe."));
		grupoProduto.setNome(grupoProdutoEntrada.getNome());
		grupoProduto.setOrdemExibicao(grupoProdutoEntrada.getOrdemExibicao());
		grupoProduto.setAtivo(grupoProdutoEntrada.isAtivo());
		
		GrupoProduto grupoProdutoAlterado = grupoProdutoRepository.save(grupoProduto);
		return new GrupoProdutoOutputDto(grupoProdutoAlterado);
	}

	@Transactional
	public void excluir(Integer id) {
		buscar(id);
		grupoProdutoRepository.deleteById(id);
		
	}

}

package br.edu.infnet.robsonpinto.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;
import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoProdutoNaoEncontradoException;
import br.edu.infnet.robsonpinto.model.repository.GrupoProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class GrupoProdutoService implements CrudService<GrupoProduto, Integer>{
	
	private final GrupoProdutoRepository grupoProdutoRepository;
	public GrupoProdutoService(GrupoProdutoRepository grupoProdutoRepository) {
		this.grupoProdutoRepository = grupoProdutoRepository;
	}
	
	@Override
	@Transactional
	public GrupoProduto buscar(Integer id) {
		return grupoProdutoRepository.findById(id).orElseThrow(() -> new GrupoProdutoNaoEncontradoException("O grupo de produto com o id " + id + " não existe."));
	}

	@Override
	@Transactional
	public List<GrupoProduto> buscarLista() {
		return grupoProdutoRepository.findAll();
	}

	@Override
	@Transactional
	public GrupoProduto criar(GrupoProduto grupoProduto) {
		if (grupoProduto.getId() != null && grupoProduto.getId() != 0) {
			throw new IllegalArgumentException("Um novo grupo de produto não pode ter um id.");
		}
		
		return grupoProdutoRepository.save(grupoProduto);
	}

	@Override
	@Transactional
	public GrupoProduto alterar(Integer id, GrupoProduto grupoProduto) {
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para alteração de um grupo de produto.");
		}
		
		buscar(id);
		grupoProduto.setId(id);
		
		return grupoProdutoRepository.save(grupoProduto);
	}

	@Override
	@Transactional
	public void excluir(Integer id) {
		buscar(id);
		grupoProdutoRepository.deleteById(id);
		
	}

}

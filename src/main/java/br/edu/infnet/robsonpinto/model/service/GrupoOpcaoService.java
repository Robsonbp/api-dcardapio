package br.edu.infnet.robsonpinto.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.domain.GrupoOpcao;
import br.edu.infnet.robsonpinto.model.domain.exceptions.GrupoOpcaoNaoEncontradoException;
import br.edu.infnet.robsonpinto.model.repository.GrupoOpcaoRepository;
import jakarta.transaction.Transactional;

@Service
public class GrupoOpcaoService implements CrudService<GrupoOpcao, Integer>{
	
	private final GrupoOpcaoRepository grupoOpcaoRepository;
	public GrupoOpcaoService(GrupoOpcaoRepository grupoOpcaoRepository) {
		this.grupoOpcaoRepository = grupoOpcaoRepository;
	}
	
	@Override
	@Transactional
	public GrupoOpcao buscar(Integer id) {
		return grupoOpcaoRepository.findById(id).orElseThrow(() -> new GrupoOpcaoNaoEncontradoException("O grupo de opção com o id " + id + " não existe."));
	}

	@Override
	@Transactional
	public List<GrupoOpcao> buscarLista() {
		return grupoOpcaoRepository.findAll();
	}

	@Override
	@Transactional
	public GrupoOpcao criar(GrupoOpcao grupoOpcao) {
		if (grupoOpcao.getId() != null && grupoOpcao.getId() != 0) {
			throw new IllegalArgumentException("Um novo grupo de opção não pode ter um id.");
		}
		
		return grupoOpcaoRepository.save(grupoOpcao);
	}

	@Override
	@Transactional
	public GrupoOpcao alterar(Integer id, GrupoOpcao grupoOpcao) {
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para alteração de um grupo de opção.");
		}
		
		buscar(id);
		grupoOpcao.setId(id);
		
		return grupoOpcaoRepository.save(grupoOpcao);
	}

	@Override
	@Transactional
	public void excluir(Integer id) {
		buscar(id);
		grupoOpcaoRepository.deleteById(id);
		
	}

}

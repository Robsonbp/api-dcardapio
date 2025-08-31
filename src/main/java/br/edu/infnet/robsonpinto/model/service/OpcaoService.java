package br.edu.infnet.robsonpinto.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.domain.Opcao;
import br.edu.infnet.robsonpinto.model.domain.exceptions.OpcaoNaoEncontradaException;
import br.edu.infnet.robsonpinto.model.repository.OpcaoRepository;
import jakarta.transaction.Transactional;

@Service
public class OpcaoService implements CrudService<Opcao, Integer>{
	
	private final OpcaoRepository opcaoRepository;
	public OpcaoService(OpcaoRepository opcaoRepository) {
		this.opcaoRepository = opcaoRepository;
	}
	
	@Override
	@Transactional
	public Opcao buscar(Integer id) {
		return opcaoRepository.findById(id).orElseThrow(() -> new OpcaoNaoEncontradaException("A opção com o id " + id + " não existe."));
	}

	@Override
	@Transactional
	public List<Opcao> buscarLista() {
		return opcaoRepository.findAll();
	}

	@Override
	@Transactional
	public Opcao criar(Opcao opcao) {
		if (opcao.getId() != null && opcao.getId() != 0) {
			throw new IllegalArgumentException("Uma nova opção não pode ter um id.");
		}
		
		return opcaoRepository.save(opcao);
	}

	@Override
	@Transactional
	public Opcao alterar(Integer id, Opcao grupoOpcao) {
		if (id == null || id == 0) {
			throw new IllegalArgumentException("É necessário passar um id para alteração de uma opção.");
		}
		
		buscar(id);
		grupoOpcao.setId(id);
		
		return opcaoRepository.save(grupoOpcao);
	}

	@Override
	@Transactional
	public void excluir(Integer id) {
		buscar(id);
		opcaoRepository.deleteById(id);
		
	}

}

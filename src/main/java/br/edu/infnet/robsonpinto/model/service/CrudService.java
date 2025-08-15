package br.edu.infnet.robsonpinto.model.service;

import java.util.List;

public interface CrudService<T, ID> {
	
	T criar(T Entity);
	T buscar();
	void excluir(ID id);
	List<T> buscarLista();
}

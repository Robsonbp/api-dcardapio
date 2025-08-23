package br.edu.infnet.robsonpinto.model.service;

import java.util.List;

public interface CrudService<T, ID> {
	
	T buscar(ID id);
	List<T> buscarLista();
	T criar(T entity);
	T alterar(ID id, T entity);
	void excluir(ID id);
}

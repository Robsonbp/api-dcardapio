package br.edu.infnet.robsonpinto.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.robsonpinto.model.domain.Produto;

@Service
public class ProdutoService implements CrudService<Produto, Integer> {

	@Override
	public Produto criar(Produto Entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto buscar() {
		Produto produto = new Produto();
		produto.setId(1);
		produto.setNome("Doce");
		produto.setDescricao("Doce muito gostoso.");
		produto.setValor(20.00);
		produto.setAtivo(true);
		
		return produto;
	}

	@Override
	public void excluir(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> buscarLista() {
		// TODO Auto-generated method stub
		return null;
	}

}

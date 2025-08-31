package br.edu.infnet.robsonpinto.model.domain.exceptions;

public class GrupoProdutoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GrupoProdutoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
}

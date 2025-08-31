package br.edu.infnet.robsonpinto.model.domain.exceptions;

public class GrupoProdutoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GrupoProdutoInvalidoException (String mensagem) {
		super(mensagem);
	}
}

package br.edu.infnet.robsonpinto.model.domain.exceptions;

public class OpcaoNaoEncontradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OpcaoNaoEncontradaException (String mensagem) {
		super(mensagem);
	}
}

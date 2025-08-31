package br.edu.infnet.robsonpinto.model.domain.exceptions;

public class OpcaoInvalidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OpcaoInvalidaException (String mensagem) {
		super(mensagem);
	}
}

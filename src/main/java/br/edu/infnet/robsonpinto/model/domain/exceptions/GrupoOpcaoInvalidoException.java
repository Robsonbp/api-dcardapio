package br.edu.infnet.robsonpinto.model.domain.exceptions;

public class GrupoOpcaoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GrupoOpcaoInvalidoException (String mensagem) {
		super(mensagem);
	}
}

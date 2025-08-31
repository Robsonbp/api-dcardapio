package br.edu.infnet.robsonpinto.model.domain.exceptions;

public class GrupoOpcaoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GrupoOpcaoNaoEncontradoException (String mensagem) {
		super(mensagem);
	}
}

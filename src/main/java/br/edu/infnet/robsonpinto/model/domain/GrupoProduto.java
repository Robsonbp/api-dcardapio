package br.edu.infnet.robsonpinto.model.domain;

public class GrupoProduto extends Grupo {
	private String ordemExibicao;
	private boolean ativo;
	
	
	@Override
	public String toString() {
		
		return String.format("%s - %s - %s",
				super.toString(), ativo ? "Ativo" : "Desativado");
	}
	
	public String getOrdemExibicao() {
		return ordemExibicao;
	}
	public void setOrdemExibicao(String ordemExibicao) {
		this.ordemExibicao = ordemExibicao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}

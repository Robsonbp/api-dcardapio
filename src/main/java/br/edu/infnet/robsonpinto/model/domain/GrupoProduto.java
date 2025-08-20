package br.edu.infnet.robsonpinto.model.domain;

public class GrupoProduto extends Grupo {
	private Integer ordemExibicao;
	private boolean ativo;
	
	
	@Override
	public String toString() {
		
		return String.format("%s - %s - %s",
				super.toString(), ativo ? "Ativo" : "Desativado");
	}
	
	public Integer getOrdemExibicao() {
		return ordemExibicao;
	}
	public void setOrdemExibicao(Integer ordemExibicao) {
		this.ordemExibicao = ordemExibicao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}

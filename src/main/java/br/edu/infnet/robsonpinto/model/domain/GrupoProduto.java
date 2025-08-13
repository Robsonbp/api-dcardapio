package br.edu.infnet.robsonpinto.model.domain;

public class GrupoProduto extends Grupo {
	public String ordemExibicao;
	public boolean ativo;
	
	
	//TODO Implementar o toString
	
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

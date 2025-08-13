package br.edu.infnet.robsonpinto.model.domain;

public class Opcao {
	public String nome;
	public int ordemExibicao;
	public boolean ativo;
	public Grupo grupo;
	
	@Override
	public String toString() {

		return String.format(
			"%s está %s",
			nome, ativo ? "disponível" : "indisponível"
			);
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getOrdemExibicao() {
		return ordemExibicao;
	}


	public void setOrdemExibicao(int ordemExibicao) {
		this.ordemExibicao = ordemExibicao;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}

package br.edu.infnet.robsonpinto.model.domain;

public abstract class Grupo {
	public Integer id;
	public String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

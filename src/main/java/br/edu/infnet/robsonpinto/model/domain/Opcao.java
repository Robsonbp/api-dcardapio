package br.edu.infnet.robsonpinto.model.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Opcao {
	@NotBlank(message = "Uma opção precisa ter um nome.")
	private String nome;
	
	@NotNull(message = "É preciso informar a ordem da opção.")
	@Min(value = 0, message = "O campo ordemExibicao não pode ser menor que zero.")
	private int ordemExibicao;
	
	@NotBlank(message = "É preciso indicar se a opção está ativa ou não.")
	private boolean ativo;
	
	@Valid
	private GrupoOpcao grupo;
	
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


	public void setGrupo(GrupoOpcao grupo) {
		this.grupo = grupo;
	}
	
}

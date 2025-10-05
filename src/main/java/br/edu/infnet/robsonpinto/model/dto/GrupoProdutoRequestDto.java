package br.edu.infnet.robsonpinto.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class GrupoProdutoRequestDto {

	@NotBlank(message = "Um grupo precisa ter um nome.")
	@Size(min = 1, max = 30, message = "O nome do grupo precisa ter entre 1 e 30 caracteres.")
	private String nome;
	
	@NotNull(message = "O campo ordemExibicao precisa ser preenchido.")
	@Min(value = 0, message = "O campo ordemExibicao não pode ser menor que zero.")
	private Integer ordemExibicao;
	
	@NotNull(message = "O campo ativo precisa ser preenchido.")
	private boolean ativo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

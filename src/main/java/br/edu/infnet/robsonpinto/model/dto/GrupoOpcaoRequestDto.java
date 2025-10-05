package br.edu.infnet.robsonpinto.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class GrupoOpcaoRequestDto {

	@NotBlank(message = "Um grupo precisa ter um nome.")
	@Size(min = 1, max = 30, message = "O nome do grupo precisa ter entre 1 e 30 caracteres.")
	private String nome;
	
	@NotNull(message = "O mínimo de escolha para esse grupo de opção precisa estar preenchido.")
	@Min(value = 0, message = "O mínimo de escolha para esse grupo de opções não pode ser menor que zero.")
	private int minimo;
	
	@Min(value = 0, message = "O campo máximo para o grupo de opções não pode ser menor que zero.")
	@Max(value = 20, message = "O campo máximo para o grupo de opções não pode ser maior que vinte.")
	private int maximo;
	
	@NotNull(message = "O campo obrigatorio precisa ser preenchido.")
	private boolean obrigatorio;
	
	@NotNull(message = "O campo ordemExibicao precisa ser preenchido.")
	@Min(value = 0, message = "O campo ordemExibicao não pode ser menor que zero.")
	private int ordemExibicao;
	
	@NotNull(message = "Um grupo de opção precisa ter um produto vinculado.")
	@Min(value = 0, message = "O id do produto vinculado não pode ser menor que 0.")
	private Integer produtoId;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public boolean isObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public int getOrdemExibicao() {
		return ordemExibicao;
	}

	public void setOrdemExibicao(int ordemExibicao) {
		this.ordemExibicao = ordemExibicao;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProduto(Integer produtoId) {
		this.produtoId = produtoId;
	}

}

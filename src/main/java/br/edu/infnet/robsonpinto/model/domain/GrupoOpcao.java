package br.edu.infnet.robsonpinto.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class GrupoOpcao extends Grupo {
	
	@NotBlank(message = "O mínimo de escolha para esse grupo de opção precisa estar preenchido.")
	@Min(value = 0, message = "O mínimo de escolha para esse grupo de opções não pode ser menor que zero.")
	private int minimo;
	
	@Min(value = 0, message = "O campo máximo para o grupo de opções não pode ser menor que zero.")
	@Max(value = 20, message = "O campo máximo para o grupo de opções não pode ser maior que vinte.")
	private int maximo;
	
	@NotBlank(message = "O campo obrigatorio precisa ser preenchido.")
	private boolean obrigatorio;
	
	@NotNull(message = "O campo ordemExibicao precisa ser preenchido.")
	@Min(value = 0, message = "O campo ordemExibicao não pode ser menor que zero.")
	private int ordemExibicao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@Override
	public String toString() {

		return String.format("%s - %d - %d - %s - %d - %s",
				super.toString() ,minimo, maximo, obrigatorio ? "Obrigatório" : "Não obrigatório", ordemExibicao, produto);
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}

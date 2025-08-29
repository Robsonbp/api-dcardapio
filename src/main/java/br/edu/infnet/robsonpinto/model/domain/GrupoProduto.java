package br.edu.infnet.robsonpinto.model.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class GrupoProduto extends Grupo {
	
	@NotNull(message = "O campo ordemExibicao precisa ser preenchido.")
	@Min(value = 0, message = "O campo ordemExibicao não pode ser menor que zero.")
	private Integer ordemExibicao;
	
	@NotBlank(message = "O campo ativo precisa ser preenchido.")
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

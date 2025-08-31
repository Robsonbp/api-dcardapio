package br.edu.infnet.robsonpinto.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class GrupoProduto extends Grupo {
	
	@NotNull(message = "O campo ordemExibicao precisa ser preenchido.")
	@Min(value = 0, message = "O campo ordemExibicao não pode ser menor que zero.")
	private Integer ordemExibicao;
	
	@NotNull(message = "O campo ativo precisa ser preenchido.")
	private boolean ativo;
	
	@OneToMany(mappedBy = "grupoProduto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Produto> produtos = new ArrayList<Produto>();
	

	@Override
	public String toString() {
		
		return String.format("%s - %d - %s",
				super.toString(), ordemExibicao, ativo ? "Ativo" : "Desativado");
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
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}

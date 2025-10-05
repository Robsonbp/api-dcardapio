package br.edu.infnet.robsonpinto.model.dto;

import java.math.BigDecimal;
import br.edu.infnet.robsonpinto.model.domain.Produto;


public class ProdutoOutputDto {
	
	private Integer id;
	private String nome;
	private String descricao;
	private BigDecimal valor;
	private boolean ativo;
	private Integer grupoProdutoId;
	private String grupoProdutoNome;
	
	public ProdutoOutputDto(Produto produto) {
		this.setId(produto.getId());
		this.setNome(produto.getNome());
		this.setDescricao(produto.getDescricao());
		this.setValor(produto.getValor());
		this.setAtivo(produto.isAtivo());
		this.setGrupoProdutoId(produto.getGrupoProduto().getId());
		this.setGrupoProdutoNome(produto.getGrupoProduto().getNome());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getGrupoProdutoId() {
		return grupoProdutoId;
	}

	public void setGrupoProdutoId(Integer grupoProdutoId) {
		this.grupoProdutoId = grupoProdutoId;
	}

	public String getGrupoProdutoNome() {
		return grupoProdutoNome;
	}

	public void setGrupoProdutoNome(String grupoProdutoNome) {
		this.grupoProdutoNome = grupoProdutoNome;
	}

	
	
}

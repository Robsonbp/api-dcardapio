package br.edu.infnet.robsonpinto.model.dto;

import br.edu.infnet.robsonpinto.model.domain.GrupoProduto;

public class GrupoProdutoOutputDto {
	
	private Integer id;
	private String nome;
	private Integer ordemExibicao;
	private boolean ativo;
	
	
	public GrupoProdutoOutputDto(GrupoProduto grupoProduto) {
		this.setId(grupoProduto.getId());
		this.setNome(grupoProduto.getNome());
		this.setOrdemExibicao(grupoProduto.getOrdemExibicao());
		this.setAtivo(grupoProduto.isAtivo());
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

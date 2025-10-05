package br.edu.infnet.robsonpinto.model.dto;

import br.edu.infnet.robsonpinto.model.domain.GrupoOpcao;


public class OpcaoOutputDto {

	private Integer id;
	private String nome;
	private int ordemExibicao;
	private boolean ativo;
	private GrupoOpcao grupoOpcao;
	
	
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
	public GrupoOpcao getGrupoOpcao() {
		return grupoOpcao;
	}
	public void setGrupoOpcao(GrupoOpcao grupoOpcao) {
		this.grupoOpcao = grupoOpcao;
	}
	
	
}

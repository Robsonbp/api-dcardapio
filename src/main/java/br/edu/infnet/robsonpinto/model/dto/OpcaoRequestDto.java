package br.edu.infnet.robsonpinto.model.dto;

import br.edu.infnet.robsonpinto.model.domain.GrupoOpcao;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OpcaoRequestDto {

	@NotBlank(message = "Uma opção precisa ter um nome.")
	private String nome;
	
	@NotNull(message = "É preciso informar a ordem da opção.")
	@Min(value = 0, message = "O campo ordemExibicao não pode ser menor que zero.")
	private int ordemExibicao;
	
	@NotNull(message = "É preciso indicar se a opção está ativa ou não.")
	private boolean ativo;
	
	@NotNull(message = "Uma opção precisa estar vinculada a um grupo de opções.")
	private GrupoOpcao grupoOpcao;

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

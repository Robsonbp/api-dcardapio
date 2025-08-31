package br.edu.infnet.robsonpinto.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Opcao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Uma opção precisa ter um nome.")
	private String nome;
	
	@NotNull(message = "É preciso informar a ordem da opção.")
	@Min(value = 0, message = "O campo ordemExibicao não pode ser menor que zero.")
	private int ordemExibicao;
	
	@NotNull(message = "É preciso indicar se a opção está ativa ou não.")
	private boolean ativo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "grupo_opcao_id", nullable = false)
	private GrupoOpcao grupoOpcao;
	
	@Override
	public String toString() {

		return String.format(
			"%d - %s - %d - %s - %s",
			id, nome, ordemExibicao, ativo ? "disponível" : "indisponível", grupoOpcao
			);
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

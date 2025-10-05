package br.edu.infnet.robsonpinto.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdutoRequestDto {

	
	@NotBlank(message = "Um produto precisa ter um nome.")
	@Size(min = 1 ,max = 30, message = "O nome do produto precisa ter entre 1 e 30 caracteres.")
	private String nome;
	
	@Size(max = 255, message = "A descrição do produto não pode ultrapassar 255 caracteres.")
	private String descricao;
	
	@NotNull(message = "O campo valor precisa ser preenchido.")
	@DecimalMin(value = "0.01", message = "O valor do produto não pode ser menor que zero.")
	@DecimalMax(value = "999999.99", message = "O valor do produto não pode ser maior que 100.000.")
	@Digits(integer = 6, fraction = 2, message = "O valor do produto precisa ter 2 casas decimais e no máximo 8 dígitos inteiros.")
	private BigDecimal valor;
	
	@NotNull(message = "O campo ativo precisa ser preenchido.")
	private boolean ativo;
	
	@NotNull(message = "O produto precisa ter um grupo vinculado.")
	@Min(value = 1, message = "O grupo vinculado precisa ter um id maior que 0.")
	private Integer grupoProdutoId;

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
	
}

package br.edu.infnet.robsonpinto.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Um produto precisa ter um nome.")
	@Size(min = 1 ,max = 30, message = "O nome do produto precisa ter entre 1 e 30 caracteres.")
	private String nome;
	
	@Size(max = 255, message = "A descrição do produto não pode ultrapassar 255 caracteres.")
	private String descricao;
	
	@NotBlank
	@Min(value = 0, message = "O valor do produto não pode ser menor que zero.")
	@Max(value = 100000, message = "O valor do produto não pode ser maior que 100.000.")
	private double valor;
	
	@NotBlank
	private boolean ativo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "grupo_produto_id")
	public GrupoProduto grupoProduto;
	
	@Override
	public String toString() {
		
		return String.format(
				"O produto com o id %d, %s, que é um %s está no valor de %.2f e está %s",
				id, nome, descricao, valor, ativo ? "disponível" : "indisponível"
				);		
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

}

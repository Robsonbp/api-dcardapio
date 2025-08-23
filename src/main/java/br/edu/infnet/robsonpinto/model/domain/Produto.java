package br.edu.infnet.robsonpinto.model.domain;

public class Produto {
	private Integer id;
	private String nome;
	private String descricao;
	private double valor;
	private boolean ativo;
	
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

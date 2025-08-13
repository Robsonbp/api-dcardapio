package br.edu.infnet.robsonpinto.model.domain;

public class Produto {
	public int id;
	public String nome;
	public String descricao;
	public double valor;
	public boolean ativo;
	
	public GrupoProduto grupoProduto;
	
	@Override
	public String toString() {
		
		return String.format(
				"O produto %s, que é um %s está no valor de %.2f e está %s",
				nome, descricao, valor, ativo ? "disponível" : "indisponível"
				);		
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

}

package br.edu.infnet.robsonpinto.model.domain;

public class Produto {
	public String nome;
	public String descricao;
	public double valor;
	public boolean ativo;
	
	@Override
	public String toString() {
		
		return String.format(
				"O produto %s, que é um %s está no valor de %.2f e está %s",
				nome, descricao, valor, ativo ? "disponível" : "indisponível"
				);		
	}
}

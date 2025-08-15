package br.edu.infnet.robsonpinto.model.domain;

public class GrupoOpcao extends Grupo {
	private int minimo;
	private int maximo;
	private boolean obrigatorio;
	private int ordemExibicao;
	
	private Produto produto;

	@Override
	public String toString() {

		return String.format("%s - %d - %d - %s - %d - %s",
				super.toString() ,minimo, maximo, obrigatorio ? "Obrigatório" : "Não obrigatório", ordemExibicao, produto);
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public boolean isObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public int getOrdemExibicao() {
		return ordemExibicao;
	}

	public void setOrdemExibicao(int ordemExibicao) {
		this.ordemExibicao = ordemExibicao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}

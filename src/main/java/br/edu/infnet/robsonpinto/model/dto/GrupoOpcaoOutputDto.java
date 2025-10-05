package br.edu.infnet.robsonpinto.model.dto;


public class GrupoOpcaoOutputDto {
	
	private Integer id;
	private String nome;
	private int minimo;
	private int maximo;
	private boolean obrigatorio;
	private int ordemExibicao;
	private ProdutoOutputDto produto;
	
	
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

	public ProdutoOutputDto getProduto() {
		return produto;
	}

	public void setProduto(ProdutoOutputDto produto) {
		this.produto = produto;
	}
}

package br.edu.infnet.robsonpinto.model.domain;

public class CnpjInfo {

	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String descricaoSituacaoCadastral;
	private String enderecoCompleto;
	
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getDescricaoSituacaoCadastral() {
		return descricaoSituacaoCadastral;
	}
	public void setDescricaoSituacaoCadastral(String descricaoSituacaoCadastral) {
		this.descricaoSituacaoCadastral = descricaoSituacaoCadastral;
	}
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
}

package br.edu.infnet.robsonpinto.model.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = "O campo valor precisa ser preenchido.")
	@DecimalMin(value = "0.01", message = "O valor do produto não pode ser menor que zero.")
	@DecimalMax(value = "999999.99", message = "O valor do produto não pode ser maior que 100.000.")
	@Digits(integer = 6, fraction = 2, message = "O valor do produto precisa ter 2 casas decimais e no máximo 8 dígitos inteiros.")
	private BigDecimal valor;
	
	@NotNull(message = "O campo ativo precisa ser preenchido.")
	private boolean ativo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "grupo_produto_id", nullable = false)
	private GrupoProduto grupoProduto;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<GrupoOpcao> gruposOpcao = new ArrayList<GrupoOpcao>();
	
	@Override
	public String toString() {
		
		return String.format(
				"produto: id=%d, nome=%s, descricao=%s, valor=R$%.2f, ativo=%s, grupo=%s",
				id,
				nome,
				descricao,
				valor,
				ativo ? "disponível" : "indisponível",
				grupoProduto != null ? String.format("grupoProdutoId=%d, grupoProdutoNome=%s", grupoProduto.getId(), grupoProduto.getNome()) : "N/A"
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
	
	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public List<GrupoOpcao> getGruposOpcao() {
		return gruposOpcao;
	}

	public void setGruposOpcao(List<GrupoOpcao> gruposOpcao) {
		this.gruposOpcao = gruposOpcao;
	}

}

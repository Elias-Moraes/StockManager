package com.StockManager.elias.StockManager.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produto")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long IdProduto;

	@Column(name = "NOME_PRODUTO")
	private String NomeProduto;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PRODUTO")
	private EnumProduto TipoProduto;

	@Column(name = "PRECO_PRODUTO")
	private double PrecoProoduto;

	@Column(name = "DESCRICAO")
	private String Descricao;

	@Column(name = "QUANTIDADE_ESTOQUE")
	private int QuantidadeEstoque;

	public Long getIdProduto() {
		return IdProduto;
	}
	

	public void setIdProduto(Long idProduto) {
		IdProduto = idProduto;
	}

	public String getNomeProduto() {
		return NomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		NomeProduto = nomeProduto;
	}

	public EnumProduto getTipoProduto() {
		return TipoProduto;
	}

	public void setTipoProduto(EnumProduto tipoProduto) {
		TipoProduto = tipoProduto;
	}

	public double getPrecoProoduto() {
		return PrecoProoduto;
	}

	public void setPrecoProoduto(double precoProoduto) {
		PrecoProoduto = precoProoduto;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public int getQuantidadeEstoque() {
		return QuantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		QuantidadeEstoque = quantidadeEstoque;
	}

}

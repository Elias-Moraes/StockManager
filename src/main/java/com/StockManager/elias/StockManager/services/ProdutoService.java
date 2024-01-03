package com.StockManager.elias.StockManager.services;

import com.StockManager.elias.StockManager.repositories.ProdutoRepository;

public class ProdutoService {

	final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

}

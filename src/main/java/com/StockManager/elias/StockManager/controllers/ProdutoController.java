package com.StockManager.elias.StockManager.controllers;

import java.util.List;

import org.hibernate.query.sqm.mutation.internal.inline.MatchingIdRestrictionProducer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.StockManager.elias.StockManager.Models.EnumProduto;
import com.StockManager.elias.StockManager.Models.ProdutoModel;
import com.StockManager.elias.StockManager.repositories.ProdutoRepository;
import com.StockManager.elias.StockManager.services.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	final ProdutoRepository produtoRepository;

	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@GetMapping
	public List<ProdutoModel> getProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/{IdProduto}")
	public ProdutoModel getProdutoId(@PathVariable Long IdProduto) {
		return produtoRepository.findById(IdProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
	}

	@PostMapping
	public ProdutoModel criarProduto(@RequestBody ProdutoModel produtoModel) {
		return produtoRepository.save(produtoModel);
	}

	@PutMapping("/{IdProduto}")
	public ProdutoModel updateProduto(@PathVariable Long IdProduto, @RequestBody ProdutoModel produtoModel) {
		ProdutoModel produtoExistente = produtoRepository.findById(IdProduto)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		produtoExistente.setNomeProduto(produtoModel.getNomeProduto());
		produtoExistente.setDescricao(produtoModel.getDescricao());
		produtoExistente.setPrecoProoduto(produtoModel.getPrecoProoduto());
		produtoExistente.setQuantidadeEstoque(produtoModel.getQuantidadeEstoque());
		produtoExistente.setTipoProduto(produtoModel.getTipoProduto());
		return produtoRepository.save(produtoExistente);

	}

	@DeleteMapping("/{IdProduto}")
	public void deleteProduto(@PathVariable Long IdProduto) {
		produtoRepository.deleteById(IdProduto);
	}
}

package br.com.alura.lojavirtual.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	List<Produto> produtos = new ArrayList<Produto>();

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}

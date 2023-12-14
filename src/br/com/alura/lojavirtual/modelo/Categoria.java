package br.com.alura.lojavirtual.modelo;

public class Categoria {

	private Integer id;
	private String nome;

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

}

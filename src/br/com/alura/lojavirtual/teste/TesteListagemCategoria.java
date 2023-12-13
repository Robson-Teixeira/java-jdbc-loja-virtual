package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.lojavirtual.dao.CategoriaDAO;
import br.com.alura.lojavirtual.factory.ConnectionFactory;
import br.com.alura.lojavirtual.modelo.Categoria;

public class TesteListagemCategoria {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			CategoriaDAO categoriaDao = new CategoriaDAO(connection);

			List<Categoria> categorias = categoriaDao.listar();

			categorias.stream().forEach(c -> System.out.println("Nome: " + c.getNome()));

		}

	}

}

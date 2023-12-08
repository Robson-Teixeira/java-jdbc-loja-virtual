package br.com.alura.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.lojavirtual.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {

		this.connection = connection;

	}

	public void salvarProduto(Produto produto) throws SQLException {

		String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?);";

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				sql, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());

			preparedStatement.execute();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

				while (resultSet.next()) {
					produto.setId(resultSet.getInt(1)); // Índice da 1ª coluna
				}

			}

		}

	}

}

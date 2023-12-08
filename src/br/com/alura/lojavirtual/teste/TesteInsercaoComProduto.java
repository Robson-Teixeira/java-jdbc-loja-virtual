package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.lojavirtual.factory.ConnectionFactory;
import br.com.alura.lojavirtual.modelo.Produto;

public class TesteInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

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

		System.out.println(produto);

	}

}

package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

public class TesteInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection connection = connectionFactory.recuperarConexao();
		connection.setAutoCommit(false);

		PreparedStatement preparedStatement = connection.prepareStatement(
				"INSERT INTO produto (nome, descricao) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);

		adicionarVariavel("Monitor", "Monitor Ultrawide 26\\\"'); DELETE FROM produto;", preparedStatement);
		adicionarVariavel("TV", "SmartTV 65\"", preparedStatement);

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement preparedStatement)
			throws SQLException {

		preparedStatement.setString(1, nome);
		preparedStatement.setString(2, descricao); // '); DELETE FROM produto;" será tratado como parte do texto

		preparedStatement.execute();
		// preparedStatement.execute retorna false (insert, update, delete e etc), pois o comando NÃO retorna uma lista (java.sql.ResultSet)
		// Inserindo o Statement.RETURN_GENERATED_KEYS é possível recuperar o(s) dado(s) processado(s)

		ResultSet resultSet = preparedStatement.getGeneratedKeys();

		while (resultSet.next()) {
			System.out.println("O id criado foi: " + resultSet.getInt(1)); // Índice da 1ª coluna
		}

		resultSet.close();

	}

}

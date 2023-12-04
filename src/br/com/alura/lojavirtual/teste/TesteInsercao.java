package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

public class TesteInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection connection = connectionFactory.recuperarConexao();

		Statement statement = connection.createStatement();
		statement.execute("INSERT INTO produto (nome, descricao) VALUES ('Mouse', 'Mouse sem fio');",
				Statement.RETURN_GENERATED_KEYS);
		// statement.execute retorna false (insert, update, delete e etc), pois o comando NÃO retorna uma lista (java.sql.ResultSet)
		// Inserindo o Statement.RETURN_GENERATED_KEYS é possível recuperar o(s) dado(s) processado(s)

		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			System.out.println("O id criado foi: " + resultSet.getInt(1)); // Índice da 1ª coluna
		}

	}

}

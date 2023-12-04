package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

public class TesteRemocaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection connection = connectionFactory.recuperarConexao();

		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE ID > ?;");
		preparedStatement.setInt(1, 2); // Índice da coluna e valor

		preparedStatement.execute();

		System.out.println("Registros afetados: " + preparedStatement.getUpdateCount());

	}

}

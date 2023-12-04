package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

public class TesteRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection connection = connectionFactory.recuperarConexao();

		Statement statement = connection.createStatement();
		statement.execute("DELETE FROM produto WHERE ID > 2;");

		System.out.println("Registros afetados: " + statement.getUpdateCount());

	}

}

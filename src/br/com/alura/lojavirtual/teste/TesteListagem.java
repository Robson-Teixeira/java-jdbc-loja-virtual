package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection connection = connectionFactory.recuperarConexao();

		Statement statement = connection.createStatement();
		statement.execute("SELECT * FROM produto");

		ResultSet resultSet = statement.getResultSet();

		while (resultSet.next()) {
			System.out.println("Id: " + resultSet.getInt("id") + 
					" | Nome: " + resultSet.getString("nome") + 
					" | Descrição: " + resultSet.getString("descricao"));
		}

		connection.close();

	}

}

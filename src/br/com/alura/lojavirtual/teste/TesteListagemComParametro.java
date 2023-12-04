package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

public class TesteListagemComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection connection = connectionFactory.recuperarConexao();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produto");
		preparedStatement.execute(); 
		// statement.execute retorna true, pois o comando retorna uma lista (java.sql.ResultSet)

		ResultSet resultSet = preparedStatement.getResultSet();

		while (resultSet.next()) {
			System.out.println("Id: " + resultSet.getInt("id") + 
					" | Nome: " + resultSet.getString("nome") + 
					" | Descrição: " + resultSet.getString("descricao"));
		}

		connection.close();

	}

}

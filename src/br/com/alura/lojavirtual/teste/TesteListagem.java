package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");

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

package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {

		// Adicionar JAR (Driver)
		/*
		 * 1- Baixar JDBC driver conector correspondente. Exemplos:
		 	* MySQL - https://dev.mysql.com/downloads/connector/j/
		 	* SQL Server - https://learn.microsoft.com/pt-br/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server
		 	* PostgreSQL - https://jdbc.postgresql.org/download/
		 	* MongoDB - https://www.mongodb.com/try/download/jdbc-driver
		 * 2- No Eclipse, acessar janela Package Explorer
		 * 3- Botão direito no projeto > Build Path > Add External Archives > Selecionar .jar correspondente
		 */

		System.out.println("Abrindo conexão...");

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "root");

		System.out.println("Conexão estabelecida com sucesso!");
		System.out.println("Fechando conexão...");

		connection.close();

		System.out.println("Conexão fechada com sucesso!");

	}

}

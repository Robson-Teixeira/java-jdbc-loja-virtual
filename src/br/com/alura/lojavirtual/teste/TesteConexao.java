package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		
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

		Connection connection = connectionFactory.recuperarConexao();

		System.out.println("Conexão estabelecida com sucesso!");
		System.out.println("Fechando conexão...");

		connection.close();

		System.out.println("Conexão fechada com sucesso!");

	}

}

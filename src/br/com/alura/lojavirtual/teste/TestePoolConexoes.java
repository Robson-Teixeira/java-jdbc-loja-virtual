package br.com.alura.lojavirtual.teste;

import java.sql.SQLException;

import br.com.alura.lojavirtual.factory.ConnectionFactory;

public class TestePoolConexoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de número: " + i);
			// Enquanto uma conexão não for liberada, uma nova não é criada, então,
			// no primeiro momento o for vai até o valor definido em setMaxPoolSize
		}

	}

}

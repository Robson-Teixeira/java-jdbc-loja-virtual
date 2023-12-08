package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.alura.lojavirtual.dao.ProdutoDAO;
import br.com.alura.lojavirtual.factory.ConnectionFactory;
import br.com.alura.lojavirtual.modelo.Produto;

public class TesteProdutoDao {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			ProdutoDAO produtoDao = new ProdutoDAO(connection);

			produtoDao.salvar(produto);

			List<Produto> produtos = produtoDao.listar();

			produtos.stream().forEach(p -> System.out.println(p));

		}

	}

}

package br.com.alura.lojavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.lojavirtual.modelo.Categoria;
import br.com.alura.lojavirtual.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {

		this.connection = connection;

	}

	public void salvar(Produto produto) throws SQLException {

		String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?);";

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				sql, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());

			preparedStatement.execute();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

				while (resultSet.next()) {
					produto.setId(resultSet.getInt(1)); // Índice da 1ª coluna
				}

			}

		}

	}

	public List<Produto> listar() throws SQLException {

		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT * FROM produto;";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.execute();

			try (ResultSet resultSet = preparedStatement.getResultSet()) {

				while (resultSet.next()) {
					produtos.add(new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}

			}

		}

		return produtos;

	}

	public List<Produto> buscar(Categoria categoria) throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();

		String sql = "SELECT * FROM produto WHERE categoria_id = ?;";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, categoria.getId());
			preparedStatement.execute();

			try (ResultSet resultSet = preparedStatement.getResultSet()) {

				while (resultSet.next()) {
					produtos.add(new Produto(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
				}

			}

		}

		return produtos;		
		
	}

}

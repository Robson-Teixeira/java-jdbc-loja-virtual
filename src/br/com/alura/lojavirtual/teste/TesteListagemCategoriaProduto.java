package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.lojavirtual.dao.CategoriaDAO;
import br.com.alura.lojavirtual.dao.ProdutoDAO;
import br.com.alura.lojavirtual.factory.ConnectionFactory;
import br.com.alura.lojavirtual.modelo.Categoria;
import br.com.alura.lojavirtual.modelo.Produto;

public class TesteListagemCategoriaProduto {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			CategoriaDAO categoriaDao = new CategoriaDAO(connection);

			List<Categoria> categorias = categoriaDao.listar();

			categorias.stream().forEach(categoria -> {

				System.out.println(categoria.getNome());

				try {

					for (Produto produto : new ProdutoDAO(connection).buscar(categoria)) {
						System.out.println(categoria.getNome() + " - " + produto.getNome());
					}

				} 
				catch (SQLException e) {
					e.printStackTrace();
				}

			});

		}

	}

}

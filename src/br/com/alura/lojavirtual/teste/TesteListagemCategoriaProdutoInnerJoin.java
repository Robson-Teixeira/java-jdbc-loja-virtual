package br.com.alura.lojavirtual.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.lojavirtual.dao.CategoriaDAO;
import br.com.alura.lojavirtual.dao.ProdutoDAO;
import br.com.alura.lojavirtual.factory.ConnectionFactory;
import br.com.alura.lojavirtual.modelo.Categoria;
import br.com.alura.lojavirtual.modelo.Produto;

public class TesteListagemCategoriaProdutoInnerJoin {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			CategoriaDAO categoriaDao = new CategoriaDAO(connection);

			List<Categoria> categorias = categoriaDao.listarComProdutos();

			categorias.stream().forEach(categoria -> {

				System.out.println(categoria.getNome());

				for (Produto produto : categoria.getProdutos()) {
					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}

			});

		}

	}

}

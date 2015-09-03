package teste;

import dao.ProdutoDAO;
import dao.factory.DaoFactory;
import model.Produto;

public class ProdutoDAOTeste {

	public static void main(String[] args) {
		
		ProdutoDAO produtoDao = DaoFactory.get().produtoDao();
		
		Produto produto = new Produto();
		produto.setNome("Produto 1");
		produto.setValor(10.0);
		
		produtoDao.inserir(produto);
	}
}

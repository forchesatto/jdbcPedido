package teste;

import dao.DaoFactory;
import dao.ProdutoDAO;
import model.Produto;

public class ProdutoDAOTeste {

	public static void main(String[] args) {
		
		ProdutoDAO produtoDao = DaoFactory.para().produtoDao();
		
		Produto produto = new Produto();
		produto.setNome("Produto 1");
		produto.setValor(10.0);
		
		produtoDao.inserir(produto);
	}
}

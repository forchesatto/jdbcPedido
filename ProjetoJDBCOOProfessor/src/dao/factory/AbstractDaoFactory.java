package dao.factory;

import dao.ProdutoDAO;

public interface AbstractDaoFactory {

	/**
	 * Retorna uma implementação valida de ProdutoDAO
	 * @return ProdutoDAO
	 */
	ProdutoDAO produtoDao();
}

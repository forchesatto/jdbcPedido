package dao.factory;

import dao.ProdutoDAO;
import dao.ProdutoDaoTexto;

public class DaoFactoryTXT implements AbstractDaoFactory{
	
	@Override
	public ProdutoDAO produtoDao() {
		return new ProdutoDaoTexto();
	}

}

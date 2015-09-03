package dao.factory;

import dao.ProdutoDAO;
import dao.ProdutoDAOJDBC;

public class DaoFactoryJDBC implements AbstractDaoFactory{

	@Override
	public ProdutoDAO produtoDao(){
		return new ProdutoDAOJDBC();
	}
	
}

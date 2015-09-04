package dao.factory;

import dao.ProdutoDAO;
import dao.ProdutoDAOJDBC;

/**
 * Fabrica concreta de Dao do tipo JDBC
 * @author forchesatto
 *
 */
public class DaoFactoryJDBC implements AbstractDaoFactory{

	@Override
	public ProdutoDAO produtoDao(){
		return new ProdutoDAOJDBC();
	}
	
}

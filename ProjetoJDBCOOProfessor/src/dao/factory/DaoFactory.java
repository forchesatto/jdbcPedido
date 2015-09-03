package dao.factory;

import dao.ProdutoDAO;

public class DaoFactory {
	
	private static DaoFactory factory;
	
	private static AbstractDaoFactory daoFactory;
	
	public static DaoFactory get(){
		if(factory == null){
			factory = new DaoFactory();
		}
		//Aqui podemos definir via parametro de um arquivo se é uma ou outra impl
		daoFactory = new DaoFactoryJDBC();
		return factory;
	}

	public ProdutoDAO produtoDao(){
		return daoFactory.produtoDao();
	}
}

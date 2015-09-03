package dao;

public class DaoFactory {

	/*
	 * Static para poder armazenar somente uma 
	 * instância no sistema inteiro.
	 */
	private static DaoFactory factory;
	
	/*
	 * Construtor oculto para não ser chamado das classes.
	 */
	private DaoFactory(){
	}

	/**
	 * Recupera a instância de um DaoFactory 
	 * utilizando o padrão Singleton.
	 * @return
	 */
	public static DaoFactory para(){
		if(factory == null){
			factory = new DaoFactory();
		}
		return factory;
	}
	
	/**
	 * Retorna uma implementação valida de ProdutoDAO
	 * @return
	 */
	public ProdutoDAO produtoDao(){
		return new ProdutoDAOJDBC();
	}
	
}

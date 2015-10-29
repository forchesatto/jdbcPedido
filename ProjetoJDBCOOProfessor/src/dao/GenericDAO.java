package dao;

import java.util.List;

import exception.ErroInserirBanco;

public interface GenericDAO<T> {

	void inserir(T entidade) throws ErroInserirBanco;
	
	void alterar(T entidade);
	
	void excluir(T entidade);
	
	T buscar(Integer id);
	
	List<T> todos();
	
}

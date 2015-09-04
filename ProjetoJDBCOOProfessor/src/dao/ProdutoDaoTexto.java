package dao;

import java.util.List;

import model.Produto;

public class ProdutoDaoTexto implements ProdutoDAO{

	@Override
	public void inserir(Produto entidade) {
		System.out.println("Salvando em texto");
	}

	@Override
	public void alterar(Produto entidade) {
		
	}

	@Override
	public void excluir(Produto entidade) {
		
	}

	@Override
	public Produto buscar(Integer id) {
		return null;
	}

	@Override
	public List<Produto> todos() {
		// TODO Auto-generated method stub
		return null;
	}

}

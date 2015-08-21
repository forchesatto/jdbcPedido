package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.Produto;

public class ProdutoDAOJDBC implements ProdutoDAO {

	private Connection con;
	
	public ProdutoDAOJDBC(){
		con = ConexaoUtil.getCon();
	}
	
	@Override
	public void inserir(Produto produto) {
		String sql = "insert into produto (nome, valor) values(?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, produto.getNome());
			pstmt.setDouble(2, produto.getValor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Produto produto) {
		String sql = "update produto set nome = ?, valor = ? where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, produto.getNome());
			pstmt.setDouble(2, produto.getValor());
			pstmt.setInt(3, produto.getCodigo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(Produto produto) {
		String sql = "delete from produto where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, produto.getCodigo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto buscar(Integer id) {
		Produto produto = null;
		String sql = "select * from produto where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				produto = new Produto();
				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}

	@Override
	public List<Produto> todos() {
		List<Produto> produtos = new ArrayList<>();
		String sql = "select * from produto";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;
	}

}

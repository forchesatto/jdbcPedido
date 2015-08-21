package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.Item;
import model.Pedido;
import model.Produto;

public class ItemDAOJDBC implements ItemDAO {

	private Connection con;
	
	public ItemDAOJDBC(){
		con = ConexaoUtil.getCon();
	}
	
	@Override
	public void inserir(Item item) {
		String sql = "insert into item (idproduto, idpedido, qtd, valor) "
				+ "values(?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, item.getProduto().getCodigo());
			pstmt.setInt(2, item.getPedido().getCodigo());
			pstmt.setDouble(3, item.getQtd());
			pstmt.setDouble(4, item.getValor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Item item) {
		String sql = "update item set idproduto = ?, idpedido=?, qtd=?,"
				+ " valor = ? where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, item.getProduto().getCodigo());
			pstmt.setInt(2, item.getPedido().getCodigo());
			pstmt.setDouble(3, item.getQtd());
			pstmt.setDouble(3, item.getValor());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(Item item) {
		String sql = "delete from item where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, item.getCodigo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Item buscar(Integer id) {
		ProdutoDAO produtoDao = new ProdutoDAOJDBC();
		Item item = null;
		String sql = "select * from item where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				item = new Item();
				item.setCodigo(rs.getInt("codigo"));
				//Nova consulta na base para buscar o produto completo
				item.setProduto(produtoDao.buscar(rs.getInt("idproduto")));
				//Só adiciono o id no Pedido e seto para o item
				item.setPedido(new Pedido(rs.getInt("idpedido")));
				item.setQtd(rs.getDouble("valor"));
				item.setValor(rs.getDouble("valor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public List<Item> todos() {
		List<Item> itens = new ArrayList<>();
		String sql = "select * from item i "
				+ "join pedido p on i.idpedido = p.codigo "
				+ "join produto pr on i.idproduto = pr.codigo";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Item item = new Item();
				item.setCodigo(rs.getInt("codigo"));
				//Nova consulta na base para buscar o produto completo
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("idproduto"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				item.setProduto(produto);
				//Só adiciono o id no Pedido e seto para o item
				item.setPedido(new Pedido(rs.getInt("idpedido")));
				item.setQtd(rs.getDouble("valor"));
				item.setValor(rs.getDouble("valor"));
				itens.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itens;
	}

}

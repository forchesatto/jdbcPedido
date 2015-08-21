package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoUtil;
import model.Pedido;

public class PedidoDAOJDBC implements PedidoDAO {

	private Connection con;
	
	public PedidoDAOJDBC(){
		con = ConexaoUtil.getCon();
	}
	
	@Override
	public void inserir(Pedido pedido) {
		String sql = "insert into pedido (data) values(?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(pedido.getData()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Pedido pedido) {
		String sql = "update pedido set data = ? where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(pedido.getData()));
			pstmt.setInt(2, pedido.getCodigo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void excluir(Pedido pedido) {
		String sql = "delete from pedido where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pedido.getCodigo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pedido buscar(Integer id) {
		Pedido pedido = null;
		String sql = "select * from pedido where codigo = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				pedido = new Pedido();
				pedido.setCodigo(rs.getInt("codigo"));
				pedido.setData(rs.getDate("data").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedido;
	}

	@Override
	public List<Pedido> todos() {
		List<Pedido> pedidos = new ArrayList<>();
		String sql = "select * from pedido";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//Transforma o resultSet em um objeto proprio
			while(rs.next()){
				Pedido pedido = new Pedido();
				pedido.setCodigo(rs.getInt("codigo"));
				pedido.setData(rs.getDate("data").toLocalDate());
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedidos;
	}

}

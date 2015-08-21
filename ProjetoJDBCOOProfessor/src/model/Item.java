package model;

public class Item {

	private Integer codigo;
	private Pedido pedido;
	private Produto produto;
	private Double qtd;
	private Double valor;

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}

	public Double getQtd() {
		return qtd;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}
}

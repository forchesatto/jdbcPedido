package model;

import java.time.LocalDate;

public class Pedido {

	private Integer codigo;
	private LocalDate data;
	
	public Pedido(){
		
	}
	
	public Pedido(Integer codigo){
		this.codigo = codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public LocalDate getData() {
		return data;
	}
}

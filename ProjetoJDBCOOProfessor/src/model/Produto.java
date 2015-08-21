package model;

public class Produto {

	private Integer codigo;
	private String nome;
	private Double valor;
	
	private String testeGit;
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}
}

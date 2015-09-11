package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.factory.DaoFactory;
import model.Produto;

public class ProdutoForm extends JFrame{

	private static final long serialVersionUID = -793851455949558200L;

	private JLabel jlbNome;
	private JTextField jtfNome;
	private JLabel jlbCodigo;
	private JTextField jtfCodigo;
	private JLabel jlbValor;
	private JTextField jtfValor;
	private JButton btnListar;
	private JButton btnSalvar;
	private static ProdutoForm produtoForm;
	
	private Produto produto;
	
	public ProdutoForm(){
		setLayout(null);
		setBounds(MAXIMIZED_VERT, MAXIMIZED_HORIZ,300,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createCodigoProduto();
		createNomeProduto();
		createValor();
		createBotao();
		createSalvar();
		
	}
	
	private void createCodigoProduto(){
		this.jlbCodigo = new JLabel("Código");
		this.jlbCodigo.setBounds(3, 10, 50, 25);
		this.jtfCodigo = new JTextField();
		this.jtfCodigo.setBounds(55, 10, 100, 25);
		add(this.jlbCodigo);
		add(this.jtfCodigo);
	}
	
	private void createNomeProduto(){
		this.jlbNome = new JLabel("Nome");
		this.jlbNome.setBounds(3, 35, 50, 25);
		this.jtfNome = new JTextField();
		this.jtfNome.setBounds(55, 35, 100, 25);
		add(this.jlbNome);
		add(this.jtfNome);
	}
	
	private void createValor(){
		this.jlbValor = new JLabel("Valor");
		this.jlbValor.setBounds(3, 65, 50, 25);
		this.jtfValor = new JTextField();
		this.jtfValor.setBounds(55, 65, 100, 25);
		add(this.jlbValor);
		add(this.jtfValor);
	}
	
	private void createBotao(){
		btnListar = new JButton("Listar");
		btnListar.setBounds(6, 95, 100, 30);
		btnListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProdutoLista produtoLista = new ProdutoLista(produtoForm);
				produtoLista.setVisible(true);
			}
		});
		add(this.btnListar);
	}
	
	private void createSalvar(){
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(110, 95, 100, 30);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				populaObjeto();
				DaoFactory.get().produtoDao().inserir(produto);
			}
		});
		add(this.btnSalvar);
	}
	
	public void populaTextField(Produto produto){
		jtfCodigo.setText(produto.getCodigo().toString());
		jtfNome.setText(produto.getNome());
		jtfValor.setText(produto.getValor().toString());
	}
	
	public void populaObjeto(){
		this.produto = new Produto();
		this.produto.setCodigo(Integer.valueOf(jtfCodigo.getText()));
		this.produto.setNome(jtfNome.getText());
		this.produto.setValor(Double.valueOf(jtfValor.getText()));
	}
	
	
	public static void main(String[] args) {
		produtoForm = new ProdutoForm();
		produtoForm.setVisible(true);
	}
}

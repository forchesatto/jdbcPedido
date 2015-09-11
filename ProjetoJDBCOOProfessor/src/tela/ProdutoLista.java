package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import dao.factory.DaoFactory;
import model.Produto;

public class ProdutoLista extends JFrame {

	private static final long serialVersionUID = 5009722415013249997L;

	private ProdutoForm produtoForm;
	private JComboBox<Produto> combo;
	private JButton botao;
	
	
	public ProdutoLista(ProdutoForm produtoForm) {
		this.produtoForm = produtoForm;
		setLayout(null);
		setBounds(MAXIMIZED_VERT, MAXIMIZED_HORIZ,300,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createCombo(DaoFactory.get().produtoDao().todos());
		createBotao();
		add(combo);
		add(botao);
	}
	
	private void createCombo(List<Produto> produtos){
		combo = new JComboBox<>(new Vector<>(produtos));
		//Renderizador especifico para combobox que desejam mostrar o atributo nome.
		combo.setRenderer(new ComboBoxNomeRenderer());
		combo.setBounds(3, 10, 150, 25);
	}
	
	private void createBotao(){
		botao = new JButton("OK");
		botao.setBounds(3, 85, 30, 20);
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Seleciona direto pois adicionamos produtos dentro do combo.
				Produto produto = (Produto)combo.getSelectedItem();
				produtoForm.populaTextField(produto);
			}
		});
	}
}

package tela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.factory.DaoFactory;
import model.Produto;

public class TesteJframe  extends JFrame{

	private static final long serialVersionUID = -2642452567387615888L;

	private JComboBox<Produto> combo;
	private JLabel label;
	private JButton botao;
	
	public TesteJframe(){
		setLayout(null);
		setBounds(MAXIMIZED_VERT, MAXIMIZED_HORIZ,300,400);
		createCombo(DaoFactory.get().produtoDao().todos());
		createLabel();
		createBotao();
		add(combo);
		add(label);
		add(botao);
	}
	
	private void createCombo(List<Produto> produtos){
		combo = new JComboBox<>(new Vector<>(produtos));
		//Renderizador especifico para combobox que desejam mostrar o atributo nome.
		combo.setRenderer(new ComboBoxNomeRenderer());
		combo.setBounds(3, 10, 150, 25);
	}
	
	private void createLabel(){
		label = new JLabel("código");
		label.setBounds(3, 45, 50, 25);
	}
	
	private void createBotao(){
		botao = new JButton("OK");
		botao.setBounds(3, 85, 30, 20);
		botao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Seleciona direto pois adicionamos produtos dentro do combo.
				Produto produto = (Produto)combo.getSelectedItem();
				label.setText(produto.getCodigo().toString());
			}
		});
	}
	
	public static void main(String[] args) {
		new TesteJframe().setVisible(true);
	}
}

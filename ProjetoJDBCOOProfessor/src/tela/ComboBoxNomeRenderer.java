package tela;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.PossuiNome;

/**
 *
 * @author andreforchesatto
 */
public class ComboBoxNomeRenderer extends JLabel implements ListCellRenderer<PossuiNome> {

	private static final long serialVersionUID = -420079977525264598L;

	public ComboBoxNomeRenderer() {
		setOpaque(true);
		setHorizontalAlignment(LEFT);
		setVerticalAlignment(CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends PossuiNome> list, PossuiNome value, int index,
			boolean isSelected, boolean cellHasFocus) {

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(Color.RED);
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		if (value != null) {
			setText(value.getNome());
			setFont(list.getFont());
		}

		return this;
	}

}

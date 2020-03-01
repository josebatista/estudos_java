package swing.calculadora.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import swing.calculadora.modelo.Memoria;

@SuppressWarnings("serial")
public class Display extends JPanel {

	private final JLabel label;

	public Display() {
		setBackground(new Color(46, 49, 50));
		this.label = new JLabel(Memoria.getInstancia().getTextoAtual());
		this.label.setForeground(Color.WHITE);
		this.label.setFont(new Font("courier", Font.PLAIN, 30));

		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		add(this.label);

	}

}

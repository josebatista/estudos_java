package swing.calculadora.visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame {

	public Calculadora() {

		organizarLayout();

		setTitle("Calculadora");
		setSize(232, 322);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void organizarLayout() {
		setLayout(new BorderLayout());

		Display display = new Display();
		display.setPreferredSize(new Dimension(232, 60));
		add(display, BorderLayout.NORTH);

		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		new Calculadora();
	}

}

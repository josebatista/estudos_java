package jogo_campo_minado_swing.visao;

import javax.swing.JFrame;

import jogo_campo_minado_swing.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);

		add(new PainelTabuleiro(tabuleiro));

		setTitle("Campo Minado");
		setSize(690, 438);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaPrincipal();
	}

}

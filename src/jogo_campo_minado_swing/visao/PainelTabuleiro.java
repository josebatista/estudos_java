package jogo_campo_minado_swing.visao;

import java.awt.GridLayout;

import javax.swing.JPanel;

import jogo_campo_minado_swing.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.paraCadaCampo(campo -> add(new BotaoCampo(campo)));
		tabuleiro.registrarObservadores(e -> {
			// TODO: informar resultado para o usuario
		});

	}

}

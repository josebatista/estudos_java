package jogo_campo_minado;

import jogo_campo_minado.modelo.Tabuleiro;
import jogo_campo_minado.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);

		new TabuleiroConsole(tabuleiro);

	}

}

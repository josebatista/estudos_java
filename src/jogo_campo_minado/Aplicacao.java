package jogo_campo_minado;

import jogo_campo_minado.modelo.Tabuleiro;

public class Aplicacao {

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);

		tabuleiro.alternarMarcacao(4, 4);
		tabuleiro.alternarMarcacao(4, 5);
		tabuleiro.abrir(3, 3);

		System.out.println(tabuleiro);

	}

}

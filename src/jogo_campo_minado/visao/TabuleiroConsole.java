package jogo_campo_minado.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import jogo_campo_minado.excecao.ExplosaoException;
import jogo_campo_minado.excecao.SairException;
import jogo_campo_minado.modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;

		this.executarJogo();
	}

	private void executarJogo() {

		try {
			boolean continuar = true;

			while (continuar) {
				this.cicloDoJogo();

				System.out.println("Outra partinda? (S/n)");
				String resposta = entrada.nextLine();

				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					this.tabuleiro.reiniciar();
				}
			}
		} catch (SairException e) {
			System.out.println("Bye bye!!");
		} finally {
			this.entrada.close();
		}

	}

	private void cicloDoJogo() {
		try {

			while (!this.tabuleiro.objetivoAlcancado()) {
				System.out.println(this.tabuleiro.toString());

				String digitado = capturarValorDigitado("Digite (x, y): ");
				Iterator<Integer> xy = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim()))
						.iterator();

				digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");

				if ("1".equals(digitado)) {
					this.tabuleiro.abrir(xy.next(), xy.next());
				} else if ("2".equals(digitado)) {
					this.tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}

			System.out.println(this.tabuleiro.toString());
			System.out.println("Voce ganhou!!!");
		} catch (ExplosaoException e) {
			System.out.println(this.tabuleiro.toString());
			System.out.println("Voce perdeu!");
		}
	}

	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = entrada.nextLine();

		if ("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}

}

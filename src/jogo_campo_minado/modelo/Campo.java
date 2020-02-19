package jogo_campo_minado.modelo;

import java.util.ArrayList;
import java.util.List;

import jogo_campo_minado.excecao.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;

	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;

	private List<Campo> vizinhos = new ArrayList<>();

	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = this.linha != vizinho.linha;
		boolean colunaDiferente = this.coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaLinha = Math.abs(this.linha - vizinho.linha);
		int deltaColuna = Math.abs(this.coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;

		if (deltaGeral == 1 && !diagonal) {
			this.vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && diagonal) {
			this.vizinhos.add(vizinho);
			return true;
		}

		return false;
	}

	void alternarMarcacao() {
		if (!this.aberto) {
			this.marcado = !this.marcado;
		}
	}

	boolean abrir() {
		if (!this.aberto && !this.marcado) {
			if (this.minado) {
				throw new ExplosaoException();
			}

			if (this.vizinhancaSegura()) {
				this.vizinhos.forEach(v -> v.abrir());
			}

			return true;
		}

		return false;
	}

	boolean vizinhancaSegura() {
		return this.vizinhos.stream().noneMatch(v -> v.minado);
	}

}

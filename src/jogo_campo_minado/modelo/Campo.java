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

	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	public boolean isAberto() {
		return this.aberto;
	}

	public boolean isMarcado() {
		return this.marcado;
	}

	public boolean isMinado() {
		return this.minado;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
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

	void minar() {
		this.minado = true;
	}

	boolean abrir() {
		if (!this.aberto && !this.marcado) {

			this.aberto = true;

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

	boolean objetivoAlcancado() {
		boolean desvendado = !this.minado && this.aberto;
		boolean protegido = this.minado && this.marcado;

		return desvendado || protegido;
	}

	long minasNaVizinhanca() {
		return this.vizinhos.stream().filter(v -> v.minado).count();
	}

	void reiniciar() {
		this.aberto = false;
		this.minado = false;
		this.marcado = false;
	}

	@Override
	public String toString() {
		if (this.marcado) {
			return "x";
		} else if (this.aberto && this.minado) {
			return "*";
		} else if (this.aberto && this.minasNaVizinhanca() > 0) {
			return Long.toString(this.minasNaVizinhanca());
		} else if (this.aberto) {
			return " ";
		} else {
			return "?";
		}
	}

}

package jogo_campo_minado.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private int minas;

	private final List<Campo> campos = new ArrayList<Campo>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;

		this.gerarCampos();
		this.associarVizinhos();
		this.sortearMinas();
	}

	public void abrir(int linha, int coluna) {
		this.campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst()
				.ifPresent(c -> c.abrir());
	}

	public void alternarMarcacao(int linha, int coluna) {
		this.campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst()
				.ifPresent(c -> c.alternarMarcacao());
	}

	private void gerarCampos() {
		for (int linha = 0; linha < this.linhas; linha++) {
			for (int coluna = 0; coluna < this.colunas; coluna++) {
				this.campos.add(new Campo(linha, coluna));
			}
		}
	}

	private void associarVizinhos() {
		for (Campo c1 : this.campos) {
			for (Campo c2 : this.campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}

	private void sortearMinas() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();

		do {
			minasArmadas = this.campos.stream().filter(minado).count();
			int aleatorio = (int) (Math.random() * this.campos.size());
			this.campos.get(aleatorio).minar();
		} while (this.minas < minasArmadas);
	}

	public boolean objetivoAlcancado() {
		return this.campos.stream().allMatch(c -> c.objetivoAlcancado());
	}

	public void reiniciar() {
		this.campos.stream().forEach(c -> c.reiniciar());
		this.sortearMinas();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		int i = 0;
		for (int l = 0; l < this.linhas; l++) {
			for (int c = 0; c < this.colunas; c++) {
				sb.append(" ");
				sb.append(this.campos.get(i));
				sb.append(" ");
				i++;
			}
			sb.append("\n");
		}

		return sb.toString();
	}

}

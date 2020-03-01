package swing.jogo_campo_minado_swing.modelo;

public class ResultadoEvento {

	private final Boolean ganhou;

	public ResultadoEvento(Boolean ganhou) {
		this.ganhou = ganhou;
	}

	public Boolean isGanhou() {
		return this.ganhou;
	}

}

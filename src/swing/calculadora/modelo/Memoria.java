package swing.calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private enum TipoComando {
		ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA;
	}

	private static final Memoria instancia = new Memoria();

	private TipoComando ultimaOperacao = null;
	private boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";

	private final List<MemoriaObservador> observadores = new ArrayList<>();

	private Memoria() {
	}

	public static Memoria getInstancia() {
		return instancia;
	}

	public void adicionarObservador(MemoriaObservador observador) {
		this.observadores.add(observador);
	}

	public String getTextoAtual() {
		return this.textoAtual.isEmpty() ? "0" : this.textoAtual;
	}

	public void processarValor(String texto) {

		TipoComando tipoComando = detectarTipoComando(texto);

		if (tipoComando == null) {
			return;
		} else if (tipoComando == TipoComando.ZERAR) {
			this.textoAtual = "";
			this.textoBuffer = "";
			this.substituir = false;
			this.ultimaOperacao = null;
		} else if (tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
			this.textoAtual = this.substituir ? texto : this.textoAtual + texto;
			this.substituir = false;
		} else {
			this.substituir = true;
			this.textoAtual = obterResultadoOperacao();
			this.textoBuffer = this.textoAtual;
			this.ultimaOperacao = tipoComando;
		}

		this.observadores.forEach(o -> o.valorAlterado(this.getTextoAtual()));
	}

	private String obterResultadoOperacao() {
		if (this.ultimaOperacao == null) {
			return this.textoAtual;
		}

		double numeroBuffer = Double.parseDouble(this.textoBuffer.replace(",", "."));
		double numeroAtual = Double.parseDouble(this.textoAtual.replace(",", "."));

		double resultado = 0;

		if (this.ultimaOperacao == TipoComando.SOMA) {
			resultado = numeroBuffer + numeroAtual;
		} else if (this.ultimaOperacao == TipoComando.SUB) {
			resultado = numeroBuffer - numeroAtual;
		} else if (this.ultimaOperacao == TipoComando.MULT) {
			resultado = numeroBuffer * numeroAtual;
		} else if (this.ultimaOperacao == TipoComando.DIV) {
			resultado = numeroBuffer / numeroAtual;
		}

		String resultadoString = Double.toString(resultado).replace(".", ",");
		boolean inteiro = resultadoString.endsWith(",0");
		return inteiro ? resultadoString.replace(",0", "") : resultadoString;
	}

	private TipoComando detectarTipoComando(String texto) {

		if (this.textoAtual.isEmpty() && texto.equals("0")) {
			return null;
		}

		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			// quando nao for numero
			if (texto.equals("AC")) {
				return TipoComando.ZERAR;
			} else if (texto.equals("/")) {
				return TipoComando.DIV;
			} else if (texto.equals("*")) {
				return TipoComando.MULT;
			} else if (texto.equals("-")) {
				return TipoComando.SUB;
			} else if (texto.equals("+")) {
				return TipoComando.SOMA;
			} else if (texto.equals("=")) {
				return TipoComando.IGUAL;
			} else if (texto.equals(",") && !this.textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
			}
		}

		return null;
	}

}

package swing.calculadora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	private static final Memoria instancia = new Memoria();

	private String textoAtual = "";

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

	public void processarValor(String valor) {
		if (valor.equals("AC")) {
			this.textoAtual = "";
		} else {
			this.textoAtual += valor;
		}
		this.observadores.forEach(o -> o.valorAlterado(this.getTextoAtual()));
	}

}

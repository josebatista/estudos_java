package estudo_stream_api.classes;

public class Aluno {

	private final String nome;
	private final double nota;

	public Aluno(String nome, double nota) {
		this.nome = nome;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public double getNota() {
		return nota;
	}

}

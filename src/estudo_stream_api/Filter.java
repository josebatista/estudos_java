package estudo_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import estudo_stream_api.classes.Aluno;

public class Filter {

	public static void main(String[] args) {

		Aluno a1 = new Aluno("Isaac", 9.8);
		Aluno a2 = new Aluno("Jose", 7.5);
		Aluno a3 = new Aluno("Pedro", 5.3);
		Aluno a4 = new Aluno("Natali", 10.0);
		Aluno a5 = new Aluno("Bia", 2.1);
		Aluno a6 = new Aluno("Gui", 6.9);

		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6);

		Predicate<Aluno> listaAprovados = a -> a.getNota() >= 7;
		Function<Aluno, String> mensagem = a -> "Parabens " + a.getNome() + "! Voce foi aprovado(a)";

		alunos.stream().filter(listaAprovados).map(mensagem).forEach(System.out::println);

	}

}

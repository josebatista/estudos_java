package estudo_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import estudo_stream_api.classes.Aluno;

public class Reduce2 {

	public static void main(String[] args) {

		Aluno a1 = new Aluno("Jose", 7.1);
		Aluno a2 = new Aluno("Gui", 6.1);
		Aluno a3 = new Aluno("Natali", 9.1);
		Aluno a4 = new Aluno("Isaac", 10.0);

		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);

		Predicate<Aluno> aprovado = a -> a.getNota() >= 7;
		Function<Aluno, Double> apenasNota = a -> a.getNota();
		BinaryOperator<Double> somatorio = (a, b) -> a + b;

		alunos.parallelStream().filter(aprovado).map(apenasNota).reduce(somatorio).ifPresent(System.out::println);

	}

}

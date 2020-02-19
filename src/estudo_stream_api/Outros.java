package estudo_stream_api;

import java.util.Arrays;
import java.util.List;

import estudo_stream_api.classes.Aluno;

public class Outros {

	public static void main(String[] args) {

		Aluno a1 = new Aluno("Jose", 7.1);
		Aluno a2 = new Aluno("Gui", 6.1);
		Aluno a3 = new Aluno("Natali", 9.1);
		Aluno a4 = new Aluno("Isaac", 10.0);
		Aluno a5 = new Aluno("Jose", 7.1);
		Aluno a6 = new Aluno("Pedro", 6.1);
		Aluno a7 = new Aluno("Joao", 9.1);
		Aluno a8 = new Aluno("Isaac", 10.0);

		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8);

		System.out.println("Distinct");
		alunos.stream().distinct().forEach(System.out::println);

		System.out.println("\nSkip/Limit");
		alunos.stream()
			.distinct()
			.skip(2)
			.limit(2)
			.forEach(System.out::println);
		
		System.out.println("\ntakeWhile");
		alunos.stream()
			.distinct()
			.skip(2)
			.takeWhile(a -> a.getNota() >= 7)
			.forEach(System.out::println);
		
	}

}

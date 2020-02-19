package estudo_stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import estudo_stream_api.classes.Aluno;

public class MinMax {

	public static void main(String[] args) {

		Aluno a1 = new Aluno("Jose", 7.1);
		Aluno a2 = new Aluno("Gui", 6.1);
		Aluno a3 = new Aluno("Natali", 9.1);
		Aluno a4 = new Aluno("Isaac", 10.0);

		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);

		Comparator<Aluno> melhorNota = (aluno1, aluno2) -> {
			if (aluno1.getNota() > aluno2.getNota())
				return 1;
			if (aluno1.getNota() < aluno2.getNota())
				return -1;
			return 0;
		};

		Comparator<Aluno> piorNota = (aluno1, aluno2) -> {
			if (aluno1.getNota() > aluno2.getNota())
				return -1;
			if (aluno1.getNota() < aluno2.getNota())
				return 1;
			return 0;
		};

		// MAX -> melhor nota entre os alunos da lista
		System.out.println(alunos.stream().max(melhorNota).get());

		// MIN -> pior nota entre os alunos da lista
		System.out.println(alunos.stream().min(melhorNota).get());

		// MAX -> pior nota entre os alunos da lista
		System.out.println(alunos.stream().max(piorNota).get());

		// MIN -> melhor nota entre os alunos da lista
		System.out.println(alunos.stream().min(piorNota).get());

	}

}

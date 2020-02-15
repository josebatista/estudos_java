package estudo_lambdas;

import java.util.Arrays;
import java.util.List;

public class Foreach {

	public static void main(String[] args) {

		List<String> aprovados = Arrays.asList("Jose", "Isaac", "Natali");

		System.out.println("Forma tradicional...");
		for (String nome : aprovados) {
			System.out.println(nome);
		}

		System.out.println("\nLambda #01...");
		aprovados.forEach(nome -> System.out.println(nome + "!!!"));

		System.out.println("\nMethod Reference #01...");
		aprovados.forEach(System.out::println);

		System.out.println("\nLambda #02...");
		aprovados.forEach(nome -> minhaImpressao(nome));

		System.out.println("\nMethod Reference #02...");
		aprovados.forEach(Foreach::minhaImpressao);

	}

	static void minhaImpressao(String nome) {
		System.out.println("Ola " + nome + " tudo certo?");
	}

}

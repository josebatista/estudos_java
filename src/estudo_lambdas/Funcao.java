package estudo_lambdas;

import java.util.function.Function;

public class Funcao {

	public static void main(String[] args) {

		Function<Integer, String> parOuImpar = n -> n % 2 == 0 ? "Par" : "Impar";

		System.out.println(parOuImpar.apply(32));
		System.out.println(parOuImpar.apply(33));

		Function<String, String> oResultadoE = valor -> "O resultado e: " + valor;

		String resultado = parOuImpar.andThen(oResultadoE).apply(33);

		System.out.println(resultado);

		Function<String, String> empolgado = valor -> valor + "!!!";

		String resultadoFinal = parOuImpar.andThen(oResultadoE).andThen(empolgado).apply(33);

		System.out.println(resultadoFinal);

	}

}

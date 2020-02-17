package estudo_lambdas;

import java.util.function.Predicate;

public class PredicadoComposicao {

	public static void main(String[] args) {

		Predicate<Integer> numeroPar = num -> num % 2 == 0;
		Predicate<Integer> temTresDigitos = num -> num >= 100 && num <= 999;

		System.out.println(numeroPar.and(temTresDigitos).test(123));
		System.out.println(numeroPar.or(temTresDigitos).test(123));
		
	}

}

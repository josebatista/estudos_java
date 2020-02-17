package estudo_lambdas;

import java.util.function.Predicate;

import estudo_lambdas.classes.Produto;

public class Predicado {

	public static void main(String[] args) {

		Predicate<Produto> estaCaro = prod -> (prod.getPreco() * (1 - prod.getDesconto())) >= 750;

		Produto prod = new Produto("Notebook", 999.99, 0.15);
		System.out.println(estaCaro.test(prod));

		prod.setDesconto(0.85);
		System.out.println(estaCaro.test(prod));

	}

}

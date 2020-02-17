package estudo_lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import estudo_lambdas.classes.Produto;

public class Desafio {

	public static void main(String[] args) {

		Produto p = new Produto("iPad", 3235.89, 0.13);

		Function<Produto, Double> valorComDesconto = prod -> prod.getPreco() * (1 - prod.getDesconto());
		UnaryOperator<Double> impostoMunicipal = valor -> valor >= 2500 ? (valor * 1.085) : valor;
		UnaryOperator<Double> frente = valor -> valor >= 3000 ? (valor + 100) : (valor + 50);
		Function<Double, String> imprimir = valor -> String.format("Preco final do produto R$%.2f", valor).replace(".",
				",");

		System.out.println(valorComDesconto.andThen(impostoMunicipal).andThen(frente).andThen(imprimir).apply(p));

	}

}

package estudo_lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import estudo_lambdas.classes.Produto;

public class Consumidor {

	public static void main(String[] args) {

		Consumer<Produto> imprimirNome = p -> System.out.println(p.getNome());
		
		Produto p1 = new Produto("Caneta", 1.25, 0.01);
		imprimirNome.accept(p1);
		
		Produto p2 = new Produto("Caderno", 10.25, 0.05);
		Produto p3 = new Produto("Lapis", 1.50, 0.01);
		Produto p4 = new Produto("Borracha", 2.25, 0.03);
		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4);

		produtos.forEach(imprimirNome);
		produtos.forEach(p -> System.out.println(p.getPreco()));
		produtos.forEach(System.out::println);
		
	}
}

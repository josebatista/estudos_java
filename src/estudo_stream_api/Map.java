package estudo_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import estudo_stream_api.classes.Util;

public class Map {

	public static void main(String[] args) {

		List<String> marcas = Arrays.asList("BMW ", "Audi ", "Honda");

		Consumer<String> print = System.out::print;

		marcas.stream().forEach(print);

		System.out.println("\n\nUtilizando map...");
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);

		UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + " ";

		System.out.println("\n\nUsando Composicao...");
		marcas.stream().map(Util.maiuscula).map(primeiraLetra).map(Util::grito).forEach(print);

	}

}

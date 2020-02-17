package estudo_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {

	public static void main(String[] args) {

		Consumer<String> print = System.out::print;
		Consumer<Integer> println = System.out::println;

		Stream<String> langs = Stream.of("Java ", "Lua ", "JS\n");
		langs.forEach(print);

		String[] maisLangs = { "Python ", "Lisp ", "Perl ", "Go\n" };

		Stream.of(maisLangs).forEach(print);
		Arrays.stream(maisLangs).forEach(print);
		Arrays.stream(maisLangs, 1, 4).forEach(print);

		List<String> outrasLangs = Arrays.asList("C ", "PHP ", "Kotlin\n");
		outrasLangs.stream().forEach(print);
		outrasLangs.parallelStream().forEach(print);

		/*
		 * gera uma stream de forma infinita
		 */
		// Stream.generate(() -> "a").forEach(print);

		/*
		 * outra forma de gerar uma stream de forma infinita (a partir de um valor
		 * inicial)
		 */
		// Stream.iterate(0, n -> n + 2).forEach(println);

	}

}

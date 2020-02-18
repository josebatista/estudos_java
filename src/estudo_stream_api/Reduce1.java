package estudo_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce1 {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		BinaryOperator<Integer> soma = (ac, n) -> ac + n;
		
		Integer soma1 = nums.parallelStream().reduce(soma).get();
		System.out.println(soma1);
		
		Integer soma2 = nums.stream().reduce(100, soma);
		System.out.println(soma2);
		
		//Resulta foi um Optional<Integer>...
		nums.stream()
			.filter(n -> n > 5)
			.reduce(soma)
			.ifPresent(System.out::println);
		
	}

}

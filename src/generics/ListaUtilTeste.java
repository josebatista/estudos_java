package generics;

import java.util.Arrays;
import java.util.List;

public class ListaUtilTeste {

	public static void main(String[] args) {

		List<String> langs = Arrays.asList("JS", "PHP", "Java", "C/C++");
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

		String ultimaLinguagem1 = (String) ListaUtil.getUltimo1(langs);
		Integer ultimoNumero1 = (Integer) ListaUtil.getUltimo1(nums);

		System.out.println(ultimaLinguagem1);
		System.out.println(ultimoNumero1);

		String ultimaLinguagem2 = ListaUtil.getUltimo2(langs);
		Integer ultimoNumero2 = ListaUtil.getUltimo2(nums);

		System.out.println(ultimaLinguagem2);
		System.out.println(ultimoNumero2);

	}

}

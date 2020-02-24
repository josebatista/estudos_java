package generics;

public class CaixaGenericsTeste {

	public static void main(String[] args) {

		/*
		 * Mesmo comportamento que o da classe CaixaObjeto.
		 * Se nao passar o tipo do dado ele espera como sendo Object
		 */
		// Caixa caixaA = new Caixa();

		CaixaGenerics<String> caixaA = new CaixaGenerics<>();
		caixaA.guardar("Ola Generics");

		String coisaA = caixaA.abrir();
		System.out.println(coisaA);

		CaixaGenerics<Double> caixaB = new CaixaGenerics<Double>();
		caixaB.guardar(3.1415);
		
		Double coisaB = caixaB.abrir();
		System.out.println(coisaB);
		
	}

}

package estudo_lambdas;

/**
 * Realizando os calculos utilizando implementacoes da interface.
 * 
 * @author jpereira
 *
 */
public class CalculoTeste1 {

	public static void main(String[] args) {

		Calculo calculo = new Somar();
		System.out.println(calculo.executar(2, 3));

		calculo = new Multiplicar();
		System.out.println(calculo.executar(2, 3));

	}
}

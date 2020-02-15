package estudo_lambdas;

@FunctionalInterface
public interface Calculo {

	public double executar(double a, double b);

	// public String teste(); - Nao permitido devido a anotacao FunctionalInterface

	/*
	 * permitido pois contem uma implementacao default fazendo com que o lambda tenha que implementar
	 * somente uma unica funcao
	 */
	default String legal() {
		return "LEGAL!!";
	}
	
	/*
	 * permitido por ser uma funcao abstrata fazendo com que o lambda tenha que implementar
	 * somente uma unica funcao
	 */
	static String show() {
		return "SHOW!!";
	}

}

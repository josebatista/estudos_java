package estudo_lambdas.classes;

public class Somar implements Calculo {

	@Override
	public double executar(double a, double b) {
		return a + b;
	}

}

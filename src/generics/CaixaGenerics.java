package generics;

public class CaixaGenerics<T> {

	private T coisa;

	public void guardar(T coisa) {
		this.coisa = coisa;
	}

	public T abrir() {
		return this.coisa;
	}

}

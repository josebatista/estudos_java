package estudo_stream_api.classes;

import java.util.function.UnaryOperator;

public class Util {

	private Util() {
	}

	public static final UnaryOperator<String> maiuscula = n -> n.toUpperCase();

	public static final String grito(String n) {
		return n + "!!! ";
	}

}

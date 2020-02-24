package generics;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Pares<C extends Number, V> {

	private final Set<Par<C, V>> itens = new LinkedHashSet<>();

	public void adicionar(C chave, V valor) {
		if (chave == null)
			return;

		Par<C, V> novoPar = new Par<C, V>(chave, valor);

		if (this.itens.contains(novoPar)) {
			this.itens.remove(novoPar);
		}

		this.itens.add(novoPar);
	}

	public V getValor(C chave) {
		if (chave == null)
			return null;

		Optional<Par<C, V>> parOptional = this.itens.stream().filter(par -> chave.equals(par.getChave())).findFirst();

		return parOptional.isPresent() ? parOptional.get().getValor() : null;
	}

}

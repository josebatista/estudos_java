package padroes.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Porteiro {

	private List<ObservadorChegadaAniversariante> observadores = new ArrayList<>();

	public void registrarObservador(ObservadorChegadaAniversariante observador) {
		this.observadores.add(observador);
	}

	public void monitorar() {
		Scanner entrada = new Scanner(System.in);

		String resposta = "";

		while (!resposta.equalsIgnoreCase("sair")) {
			System.out.print("Aniversariante chegou? (s/n) ");
			resposta = entrada.nextLine();

			if (resposta.equalsIgnoreCase("s")) {
				// cria o evento
				EventoChegadaAniversariante evento = new EventoChegadaAniversariante(new Date());

				// notificar observadores
				this.observadores.stream().forEach(o -> o.chegou(evento));

				resposta = "sair";
			} else {
				System.out.println("Alarme falso!!");
			}
		}

		entrada.close();
	}

}

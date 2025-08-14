package observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Porteiro extends Thread {

	private List<ChegadaAniversarianteObserver> observers = new ArrayList<ChegadaAniversarianteObserver>();

	public void AddChegadaAniversarianteObserver(ChegadaAniversarianteObserver observer) {
		this.observers.add(observer);
	}

	@SuppressWarnings("resource")
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			int valor = scan.nextInt();

			if (valor == 1) {
				ChegadaAniversarianteEvent event = new ChegadaAniversarianteEvent(new Date());

				// Notificar observer

				for (ChegadaAniversarianteObserver observer : this.observers) {
					observer.chegou(event);
				}

			} else {
				System.out.println("Alarme falso!!!");
			}

		}
	}

}

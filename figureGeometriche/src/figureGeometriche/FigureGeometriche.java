package figureGeometriche;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FigureGeometriche {

	public static void main(String[] args) {
		// inizializzazione input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(input);
		String readNum;
		double num = 0;

		// dichiarazione e creazione degli oggetti
		Circle cerchio;
		cerchio = new Circle(); // creazione dell'istanza

		// inserimento input
		System.out.println("Inserisci raggio del cerchio per calcolare l'area");
		try {
			readNum = keyboard.readLine();
			num = Double.valueOf(readNum).doubleValue();
		} catch (Exception e) {
			System.out.println("Errore... \nChiusura programma in corso...");
		}

		// uso dei metodi
		cerchio.setRadius(num);
		System.out.println("Il raggio del cerchio è " + cerchio.area());

	}

}

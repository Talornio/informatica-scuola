package animali;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		InputStreamReader input  = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(input);
		final int MAX = 3;
		int select = 0;
		String nome;
		String ordine;
		int ap;
		Animale v[] = new Animale[MAX];
		
		for(int i = 0; i < MAX; i++) {
			
			do {
				System.out.println("Inserisci 1 per cane, 2 per pitone, 3 per usignolo.");
				try {
					select  = Integer.valueOf(keyboard.readLine()).intValue();
				}catch(Exception e) {
					System.out.println("Errore, inserisci nuovamente.");
					continue;
				}
			}while(select < 1 || select > 3);
			
			System.out.println("Inserisci nome del "+(i+1)+"o animale");
			try {
				nome  = keyboard.readLine();
			}catch(Exception e) {
				System.out.println("Errore, inserisci nuovamente.");
				continue;
			}
			System.out.println("Inserisci ordine del "+(i+1)+"o animale");
			System.out.println("Mammiferi, rettili o uccelli?");
			try {
				ordine  = keyboard.readLine();
			}catch(Exception e) {
				System.out.println("Errore, inserisci nuovamente.");
				continue;
			}
			switch(select) {
			case 1:
				v[i] = new Cane(nome, ordine);
				break;
			case 2:
				v[i] = new Pitone(nome, ordine);
			    break;
			case 3:
				System.out.println("Inserisci anche apertura alare.");
				try {
					ap = Integer.valueOf(keyboard.readLine()).intValue();
				}catch(Exception e) {
					System.out.println("Errore, inserisci nuovamente.");
					return;
				}
				v[i] = new Usignolo(nome, ordine, ap);
				break;
			default:
				System.out.println("Ordine non corretto, inserisci nuovamente.");
				break;
			}
		}
		for(int i = 0; i < MAX; i++) {
			System.out.println(" ");
			v[i].visualizza();
			v[i].verso();
			if(v[i] instanceof Cane) {
				((Cane) v[i]).ringhia();
			}
		}
	}

}

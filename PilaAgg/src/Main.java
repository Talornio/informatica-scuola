
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(input);
		int select = -1;
		int select2 = -2;
		Pila pila = new Pila();
		
		do {
			System.out.println("Inserisci 0 per inserire una stringa nella pila,");
			System.out.println("Inserisci 1 per rimuovere una stringa nella pila,");
			System.out.println("Inserisci 2 per visualizzare una stringa nella pila,");
			System.out.println("Inserisci 3 per uscire dal programma.");
			try {
				select = Integer.valueOf(keyboard.readLine()).intValue();
				}catch(Exception e) {
				System.out.println("Errore...");
				continue;
			}
			switch(select) {
			case 0:
				System.out.println("Inserisci 1 per intero o 2 per stringa");
				try {
					select2 = Integer.valueOf(keyboard.readLine()).intValue();
					}catch(Exception e) {
					System.out.println("Errore...");
					continue;
					}
				switch(select2) {
				case 1:
					System.out.println("Inserisci il numero");
					try {
						pila.push(Integer.valueOf(keyboard.readLine()));
					}catch(Exception e) {
						System.out.println("Errore...");
						continue;
					}
					break;
				case 2:
					System.out.println("Inserisci la stringa");
					try {
						pila.push(keyboard.readLine());
					}catch(Exception e) {
						System.out.println("Errore...");
						continue;
					}
					break;
				default:
					System.out.println("Inserimento non corretto");
					break;
				}
				break;
			case 1:
				System.out.println(""+pila.pop());
				break;
			case 2:
				if(pila.top() instanceof Integer) {
					System.out.println(""+((Integer)pila.top()).intValue());
				}
				if(pila.top() instanceof String) {
					System.out.println((String)pila.top());
				}
				break;
			}
			
		}while(select != 3);
		
		System.out.println("Uscita dal programma...");
	}

}
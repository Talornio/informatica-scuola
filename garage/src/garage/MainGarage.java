package garage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainGarage {

	public static void main(String[] args) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader keyboard = new BufferedReader(input);
		int annoImmatricolazione;
		String marca;
		String tipoAlimentazione;
		int cilindrata;
		int capacitaCarico;
		int numPorte;
		String tipologia;
		int numTempiMotore;
		String tipoVeicolo;
		int select;
		
		System.out.println("inserisci 1 per immettere un nuovo veicolo, inserisci 2 per estrarre un veicolo, inserisci 3 per visualizzare il garage");
		do {
			try {
				select = Integer.valueOf(keyboard.readLine()).intValue();
			}catch(Exception e) {
				
			}
		}while (select)
		
		switch(select)
	}

}

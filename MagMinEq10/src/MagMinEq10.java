import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MagMinEq10 {
	public static void main(String args[]){
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera =  new BufferedReader(input);
		
		int num;
		
		System.out.println("Inserisci un numero");
		try{
			String readNum = tastiera.readLine();
			num = Integer.valueOf(readNum).intValue();
		}catch(Exception e){
			System.out.println("Errore... \nChiusura programma in corso...");
			return;
		}
		
		if(num == 10){
			System.out.println("Il numero inserito è uguale a 10");
		}else if(num < 10){
			System.out.println("Il numero inserito è minore di 10");
		}else{
			System.out.println("Il numero inserito è maggiore di 10");
		}
	}
}

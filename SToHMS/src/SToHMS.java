import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SToHMS {
	public static void main(String args[]){
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera =  new BufferedReader(input);
		
		int s = 0;
		int m, o;
		
		System.out.println("Inserisci un numero");
		try{
			String readNum;
			readNum = tastiera.readLine();
			s = Integer.valueOf(readNum).intValue();
		}catch(Exception e){
			System.out.println("Errore... \nChiusura programma in corso...");
			return;
		}
		
		o = s / 3600;
		m = (s % 3600) / 60;
		s = (s % 3600) % 60;
		
		System.out.println("Ore = " +o+ "\nMinuti = " +m+ "\nSecondi = " +s);
		
	}
}

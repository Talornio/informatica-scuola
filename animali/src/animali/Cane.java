package animali;

public class Cane extends Animale {
	public Cane(String nome, String ordine) {
		super(nome, ordine);
	}
	public void verso() {
		System.out.println("Bau Bau!");
	}
	public void ringhia() {
		System.out.println("Grrrr!");
	}
}

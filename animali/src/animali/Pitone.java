package animali;

public class Pitone extends Animale {
	public Pitone(String nome, String ordine) {
		super(nome, ordine);
	}
	public void verso() {
		System.out.println("Ssssh!");
	}
}

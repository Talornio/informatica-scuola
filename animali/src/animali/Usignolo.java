package animali;

public class Usignolo extends Animale{
	private int aperturaAlare;
	public Usignolo(String nome, String ordine, int aperturaAlare) {
		super(nome, ordine);
		this.aperturaAlare = aperturaAlare;
	}
	public void verso() {
		System.out.println("Cip Cip!");
	}
	public int getAperturaAlare() {
		return aperturaAlare;
	}
	public void setAperturaAlare(int aperturaAlare) {
		this.aperturaAlare = aperturaAlare;
	}
	public void visualizza() {
		super.visualizza();
		System.out.println("Apertura Alare: "+aperturaAlare);
	}
}

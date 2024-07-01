package animali;

public class Animale {
	
	//attributi
	private String nome;
	private String ordine;
	
	//metodi
	public Animale(String nome, String ordine) {
		this.nome = nome;
		this.ordine = ordine;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOrdine() {
		return ordine;
	}
	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}
	
	public void verso() {
		System.out.println("$*%#!");
	}
	public void visualizza() {
		System.out.println("Nome: "+nome);
		System.out.println("Ordine: "+ordine);
	}
}

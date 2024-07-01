package garage;

public class Furgone extends VeicoloAMotore{
	//attributi
	private int capacitaCarico;

	//metodi
	public Furgone(int annoImmatricolazione, String marca, String tipoAlimentazione, int cilindrata, int capacitaCarico) {
		super(annoImmatricolazione, marca, tipoAlimentazione, cilindrata);
		this.capacitaCarico = capacitaCarico;
	}
	
	public int getCapacitaCarico() {
		return capacitaCarico;
	}

	public void setCapacitaCarico(int capacitaCarico) {
		this.capacitaCarico = capacitaCarico;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Capacita carico=" + capacitaCarico;
	}
	
	
}

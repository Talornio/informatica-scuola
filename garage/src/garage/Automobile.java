package garage;

public class Automobile extends VeicoloAMotore{
	//attributi
	private int numPorte;

	//metodi
	public Automobile(int annoImmatricolazione, String marca, String tipoAlimentazione, int cilindrata, int numPorte) {
		super(annoImmatricolazione, marca, tipoAlimentazione, cilindrata);
		this.numPorte = numPorte;
	}

	public int getNumPorte() {
		return numPorte;
	}

	public void setNumPorte(int numPorte) {
		this.numPorte = numPorte;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Numero porte=" + numPorte;
	}
	
	
}

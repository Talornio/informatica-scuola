package garage;

public class Motocicletta extends VeicoloAMotore{
	//attributi
	private String tipologia;
	private int numTempiMotore;
	
	//metodi
	public Motocicletta(int annoImmatricolazione, String marca, String tipoAlimentazione, int cilindrata,
			String tipologia, int numTempiMotore) {
		super(annoImmatricolazione, marca, tipoAlimentazione, cilindrata);
		this.tipologia = tipologia;
		this.numTempiMotore = numTempiMotore;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public int getNumTempiMotore() {
		return numTempiMotore;
	}

	public void setNumTempiMotore(int numTempiMotore) {
		this.numTempiMotore = numTempiMotore;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Tipologia=" + tipologia + "\n Tempi motore=" + numTempiMotore;
	}
}

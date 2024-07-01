package garage;



public class Garage {
	//attributi
	private final int MAX = 15;
	private VeicoloAMotore v[] = new VeicoloAMotore[MAX];
	private int dim = 0;
	
	
	
	//metodi
	public void ImmettiNuovoVeicolo() {
		if(dim < MAX) {
			dim++;
			
			v[dim] = new ;
		}else {
			System.out.println("Per inserire un nuovo veicolo devi prima estrarne uno.");
		}
	}



	public int getDim() {
		return dim;
	}



	public void setDim(int dim) {
		this.dim = dim;
	}
}

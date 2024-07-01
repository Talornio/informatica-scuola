package figureGeometriche;

public class Circle extends FigureGeometriche {
	// attributi della classe
	private double radius;

	// metodi della classe
	public void setRadius(double r) {
		radius = r;
	}

	public double area() {
		return (radius * radius * Math.PI);
	}
}

package modele;

public class Point {

	//Attributs
	private double x;
	private double y;

	//Constructeur
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	//Méthode qui retourne l'abscisse
	public double getX() {
		return x;
	}

	//Méthode qui modifie l'abscisse
	public void setX(double d) {
		this.x = d;
	}

	//Méthode qui retourne l'ordonnée
	public double getY() {
		return y;
	}

	//Méthode qui modifie l'ordonnée
	public void setY(double d) {
		this.y = d;
	}

}

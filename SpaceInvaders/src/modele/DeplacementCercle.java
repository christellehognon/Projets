package modele;


public class DeplacementCercle implements IDeplacement{
	//Attributs
	Point position;
	private double x,y;
	double angle = 0.0;
//	private int direction = 1;
	
	//Constructeur
	public DeplacementCercle (Point point, double angle){
		this.position = point;
		this.x = point.getX();
		this.y = point.getY();
		this.angle = angle;
		//System.out.println(position.getX() + " / " + x);
	}
	
	//Redéfinition de la méthode deplacer
	@Override
	public void deplacer() {
		int rayon = 230;
		angle += 0.02;
		//System.out.println(x);
		position.setX(x + 170 + rayon*Math.cos(angle));	
		position.setY(y + rayon*Math.sin(angle));
	}

	// accesseur, méthode getPoint
	
	public Point getPoint() {	
		return position;
	}

	@Override
	public void setPas(int delta) {
		// TODO Auto-generated method stub
		
	}
}

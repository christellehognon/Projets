package modele;

public class DeplacementVaisseau implements IDeplacement  {
		
	private Point position;
	private int pas;
	private double x,y;
	//private int direction = -1;

	

	public DeplacementVaisseau(Point position) {
		super();
		this.position = position;
		this.x = position.getX();
		this.y = position.getY();
		
	}

	@Override
	public void deplacer() {
		position.setX(x + pas);
		position.setY(y);
		
	}

	@Override
	public Point getPoint() {
		
		return position;
	}

	public void setPas(int delta){
		this.pas += delta;		
	}
}

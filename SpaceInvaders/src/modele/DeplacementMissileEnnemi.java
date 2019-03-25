package modele;

public class DeplacementMissileEnnemi implements IDeplacement{
	
	private Point position;
	private int pas = 10;
	private double x,y;
	
	

	public DeplacementMissileEnnemi(Point position) {
		super();
		this.position = position;
		this.x = position.getX();
		this.y = position.getY();
		
	}

	@Override
	public void deplacer() {		
		position.setY(y += pas);
		position.setX(x);
		
	}

	@Override
	public Point getPoint() {
		
		return position;
	}

	public void setPas(int delta){
		
	}

}

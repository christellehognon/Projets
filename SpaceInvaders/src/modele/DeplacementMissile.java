package modele;

public class DeplacementMissile implements IDeplacement{
	
	private Point position;
	private int pas = -15;
	private double x,y;
	
	

	public DeplacementMissile(Point position) {
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

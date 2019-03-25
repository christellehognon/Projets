package modele;

public class DeplacementBouclier implements IDeplacement{

	private Point position;
	private int pasX;
	private double x,y;

	public DeplacementBouclier(Point position) {
		super();
		this.position = position;
		this.x = position.getX();
		this.y = position.getY();
	}

	@Override
	public void deplacer() {	
		/*
			if (position.getX() <= 70){
				position.setX(x += 3);
			}
			
			if (position.getX() >= 90){
				position.setX(x += -3);
			}	
			*/	
	}

	@Override
	public Point getPoint() {
		return position;
	}

	@Override
	public void setPas(int delta) {
		// TODO Auto-generated method stub		
	}
}

package modele;

public class DeplacementEscalier implements IDeplacement{
	
		//Attributs
		private Point position;
		private double x, y;
		private int pasX = 3;
		private int pasY = 3;
		int phase = 1;
		double yDep;
		//private int direction = 1;
		
		//Constructeur
		public DeplacementEscalier (Point point){
			this.position = point;
			this.x = point.getX();
			this.y = point.getY();	
		}

		//Redéfinition de la méthode deplacer
		@Override
		public void deplacer() {
			switch (phase)
			{
			case  1 :
				position.setX(x += pasX);
				if(x > 985){
					phase = 2;
				}				
				yDep = position.getY();
				break;

			case 2 :
				
				position.setY(y += pasY);
				if (position.getY() > yDep + 60){
					phase = 3;
				} 
				break;
				
			case 3 :
								
				position.setX(x -= pasX);
				if (x < 0){
					phase = 4;
				}
				yDep = position.getY();
				break;
			case 4 :
				
				position.setY(y += pasY);
				if (position.getY() > yDep + 60){
					phase = 1;
				}			
				break;
			}
		}

		//accesseur, méthode getPoint
		
		public Point getPoint() {
		
		return position;
	}

		@Override
		public void setPas(int delta) {
			// TODO Auto-generated method stub
			
		}

}

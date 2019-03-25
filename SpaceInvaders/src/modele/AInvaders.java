package modele;

import Vue.IDessin;

public abstract class AInvaders implements IDeplacement, IDessin {
	
	//attributs
	IDessin monDessin;
	public IDeplacement monDeplacement;
	private int direction;
	
	
	
	
	

	@Override
	public abstract void deplacer();
	
	@Override 
	public abstract void dessiner();

	public boolean collision (AInvaders a){
		boolean res = false;
							
			if (this.getPoint().getX() < a.getPoint().getX() + a.getLargeur() 
				&& this.getPoint().getY() < a.getPoint().getY() + a.getHauteur()
				&& this.getPoint().getX() > a.getPoint().getX()
				&& this.getPoint().getY() > a.getPoint().getY()){
				res = true;
			}
			if (this.getPoint().getX() < a.getPoint().getX() + a.getLargeur()
				&& this.getPoint().getY() + this.getHauteur() > a.getPoint().getY()
				&& this.getPoint().getX() > a.getPoint().getX()
				&& this.getPoint().getY() + a.getHauteur() < a.getPoint().getY() + a.getHauteur()){
				res = true;
			}
			if (this.getPoint().getX() + this.getLargeur() > a.getPoint().getX()
				&& this.getPoint().getY() + this.getHauteur() > a.getPoint().getY()
				&& this.getPoint().getX() + this.getLargeur() < a.getPoint().getX() + a.getLargeur()
				&& this.getPoint().getY() + this.getHauteur() < a.getPoint().getY() + a.getHauteur()){
				res = true;
			}
			if (this.getPoint().getX() + this.getLargeur() > a.getPoint().getX()
				&& this.getPoint().getY() < a.getPoint().getY() + a.getHauteur()
				&& this.getPoint().getX() + this.getLargeur() < a.getPoint().getX() + a.getLargeur()
				&& this.getPoint().getY() > a.getPoint().getY()){
				res = true;			
			}
		return res;
	}
	
	
	public int getHauteur(){
		return this.hauteur();
	}
	public int getLargeur(){
		return this.largeur();
	}
	public int getDirection() {
		return direction;
	}
	
}

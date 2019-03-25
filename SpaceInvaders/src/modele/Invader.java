package modele;

import Vue.IDessin;

//sprite

public class Invader extends AInvaders {

	
	//attributs
	IDessin monDessin;
	IDeplacement monDeplacement;
	private int direction = 1;

	

	//constructeur
	public Invader(IDessin monDessin, IDeplacement monDeplacement) {		
		super();
		this.monDessin = monDessin;
		this.monDeplacement = monDeplacement;
	}

	// Redéfinition de la méthode getPoint
	@Override
	public Point getPoint() {
		return	monDeplacement.getPoint();
	}
	
	//Redéfinition de la méthode deplacer
	@Override
	public void deplacer() {
		monDeplacement.deplacer();

	}
	
	//Redéfinition de la méthode dessiner
	@Override
	public void dessiner() {
		monDessin.dessiner();

	}

	public int getDirection() {
		return direction;
	}

	@Override
	public void setPas(int delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hauteur() {
		
		return monDessin.hauteur();
	}

	@Override
	public int largeur() {
		
		return monDessin.largeur();
	}
	
	public String toString(){
		return " invaders : " + monDessin;
	}

	
	
}

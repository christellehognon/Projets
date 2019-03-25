package modele;

import Vue.IDessin;

public class Bouclier extends AInvaders {

	
	IDessin monDessin;
	
	
	public int hauteur() {
		
		return monDessin.hauteur();
	}



	
	public int largeur() {
		
		return monDessin.largeur();
	}



	@Override
	public Point getPoint() {
		
		return	monDeplacement.getPoint();
	}



	@Override
	public void setPas(int delta) {
		
		
	}



	@Override
	public void deplacer() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}

}

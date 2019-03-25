package modele;

import Vue.IDessin;

public class MissileEnnemi extends AInvaders {


	//attributs
	IDessin monDessin;
	public IDeplacement monDeplacement;
	private int direction = 1;

	//constructeur
	public MissileEnnemi(IDessin monDessin, IDeplacement monDeplacement) {
		super();
		this.monDessin = monDessin;
		this.monDeplacement = monDeplacement;
	}



	@Override
	public Point getPoint() {
		return	monDeplacement.getPoint();
	}

	@Override
	public void deplacer() {
		monDeplacement.deplacer();

	}

	@Override
	public void dessiner() {
		monDessin.dessiner();

	}



	@Override
	public void setPas(int delta) {
		monDeplacement.setPas(delta);
		
	}
	
	public int getDirection() {
		return direction;
	}



	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return monDessin.hauteur();
	}



	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return monDessin.largeur();
	}
}

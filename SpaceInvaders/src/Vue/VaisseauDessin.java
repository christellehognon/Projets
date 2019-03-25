package Vue;

import modele.IDeplacement;
import processing.core.PApplet;

public class VaisseauDessin extends ADessin{

	public VaisseauDessin(PApplet fenetre, IDeplacement deplacement) {
		super(fenetre, deplacement);
		image = fenetre.loadImage("space-fighter.png");
		image.resize(50, 0);
	}

	@Override
	public int hauteur() {
		return image.height;
	}

	@Override
	public int largeur() {
		return image.width;
	}
	
	

}

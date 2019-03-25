package Vue;

import modele.IDeplacement;
import processing.core.PApplet;

public class DessinMissileEnnemi extends ADessin {

	public DessinMissileEnnemi(PApplet fenetre, IDeplacement deplacement){
		super(fenetre, deplacement);
		image = fenetre.loadImage("MissileEnnemi.png");
		image.resize(3, 0);
	}
	
	public int largeur(){
		return image.width;
	}
	public int hauteur(){
		return image.height;
	}

}

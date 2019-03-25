package Vue;

import modele.IDeplacement;
import processing.core.PApplet;

public class DessinMissile extends ADessin{

	public DessinMissile(PApplet fenetre, IDeplacement deplacement){
		super(fenetre, deplacement);
		image = fenetre.loadImage("missile.png");
		image.resize(2, 0);
	}
	
	public int largeur(){
		return image.width;
	}
	public int hauteur(){
		return image.height;
	}
}

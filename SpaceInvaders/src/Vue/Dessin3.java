package Vue;

import modele.IDeplacement;
import processing.core.PApplet;
//Création du monstre violet

public class Dessin3 extends ADessin{

	public Dessin3(PApplet fenetre, IDeplacement deplacement) {
		super(fenetre, deplacement);
		image = fenetre.loadImage("MonstreP.gif");
		image.resize(50, 0);
	}

	public int largeur(){
		return image.width;
	}
	public int hauteur(){
		return image.height;
	}
}

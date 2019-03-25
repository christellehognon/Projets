package Vue;

import modele.IDeplacement;
import processing.core.PApplet;
//Création du monstre vert

public class Dessin2 extends ADessin{
	
	
	public Dessin2(PApplet fenetre, IDeplacement deplacement){
		super(fenetre, deplacement);
		image = fenetre.loadImage("MonstreV.png");
		image.resize(50, 0);
	}
	public int largeur(){
		return image.width;
	}
	public int hauteur(){
		return image.height;
	}
}

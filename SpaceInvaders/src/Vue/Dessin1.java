package Vue;

import modele.IDeplacement;
import processing.core.PApplet;
import processing.core.PImage;
//Création du monstre rouge

public class Dessin1 extends ADessin{
	
	public Dessin1(PApplet fenetre, IDeplacement deplacement){
		super(fenetre, deplacement);
		image = fenetre.loadImage("MonstreR.png");
		image.resize(50, 0);	
	}
	
	public int largeur(){
		return image.width;
	}
	public int hauteur(){
		return image.height;
	}
}

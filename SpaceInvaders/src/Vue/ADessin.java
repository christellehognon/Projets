package Vue;


import java.awt.Image;
import processing.core.PApplet;
import processing.core.PImage;
import modele.IDeplacement;
import modele.Point;


public abstract class ADessin implements IDessin {
	
	//Attributs
	protected IDeplacement deplacement;
	protected PApplet fenetre; 
	protected PImage image;
	
	//Constructeur
	public ADessin (PApplet fenetre, IDeplacement deplacement){
		this.fenetre = fenetre;
		this.deplacement = deplacement;
	}
	
	//Redéfinition de la méthode dessiner
	@Override
	public void dessiner(){
		
		fenetre.image(image, (float) deplacement.getPoint().getX(), (float) deplacement.getPoint().getY());
	}

}

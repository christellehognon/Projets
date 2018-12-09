package tron;

//import processing.core.PApplet; //pour utiliser les fonctionnalites de Processing
import java.awt.Color;

/**
 * @author lecarrou
 * boutons de navigation
 */

public class Bouton {
	
	// attributs
	private float x, y;   
	private String texte;
	private float largeur = 400;
	private float hauteur = 50;
	private float coin =20;
	private Fenetre fenetre;
	private Color boutonFondColor;
	private Color boutonTexteColor;
	
	Bouton(float x, float y, String t, Color cf, Color ct, Fenetre F) {
	this.x = x;
	this.y = y;
	this.texte = t;
	this.boutonFondColor = cf;
	this.boutonTexteColor = ct;
	this.fenetre = F;
	}
	
	/**
	 * méthode de classe permettant de dessiner les boutons de navigation
	 */
	void dessiner() {
		fenetre.fill(this.boutonFondColor.getRGB());
		//fenetre.rectMode(fenetre.CENTER);
		fenetre.rect(this.x, this.y, this.largeur, this.hauteur, this.coin);
		float xc = this.x + this.largeur/2;
		float yc = this.y + this.hauteur/2;
		fenetre.fill(this.boutonTexteColor.getRGB());
		fenetre.textSize(24);
		fenetre.textAlign(fenetre.CENTER, fenetre.CENTER);
		fenetre.text(texte, xc, yc);	
	}
	
	/**
	 * @return boolean
	 * méthode qui teste la position de la souris avant le click
	 */
	boolean contient_souris() {
		 return (this.x <= fenetre.mouseX)  && 
				(fenetre.mouseX < this.x + this.largeur) && 
				(this.y <= fenetre.mouseY)  && 
				(fenetre.mouseY < this.y + this.hauteur);
		 }
}


package tron;


//import processing.core.PApplet; //pour utiliser les fonctionnalites de Processing
import java.awt.Color;


/**
 * Classe qui permet de créer les joueurs (snake)
 * @param t  le tableau à trier
 */

public class Snake {

	/**
	 * constructeur de la classe
	 * @param nom 			le nom du joueur
	 * @param xPos 			la position x de départ du joueur
	 * @param yPos 			la position y de départ du joueur
	 * @param snakeColor 	la couleur du joueur
	 * @param xDeplacement 	déplacement en x du joueur
	 * @param yDeplacement 	déplacement en y du joueur
	 */

	private String nom;
	private int xPos;
	private int yPos;
	private Color snakeColor;
	private Fenetre fenetre;
	private int xDeplacement;
	private int yDeplacement;

	/**
	 * methodes get() : recupéreration des valeurs de xPos, yPos, xDeplacement et yDeplacement
	 * méthodes set() : affection d'une nouvelle valeur à xDeplacement et yDeplacement
	 */

	int getxPos(){
		return this.xPos;
	}

	int getyPos(){
		return this.yPos;
	}

	int getxDeplacement(){
		return this.xDeplacement;
	}

	void setxDeplacement(int x){
		this.xDeplacement= x;
	}

	int getyDeplacement(){
		return this.yDeplacement;
	}

	void setyDeplacement(int y){
		this.yDeplacement= y;
	}

	Snake (String nom, int X, int Y, Color C, Fenetre F, int XDeplacement, int YDeplacement){
		this.nom=nom;
		this.xPos = X;
		this.yPos = Y;
		this.snakeColor = C;
		this.fenetre = F;
		this.xDeplacement = XDeplacement;
		this.yDeplacement = YDeplacement;
	}

	/**
	 * méthode permettant de dessiner les joueurs
	 */
	void dessinerSnake(){
		fenetre.noStroke();
		fenetre.fill(this.snakeColor.getRGB());
		fenetre.rect(this.xPos+1,this.yPos+1, Fenetre.tailleCase-1, Fenetre.tailleCase-1);
	}

	/**
	 * méthode permettant aux joueurs de déplacer les serpents
	 */
	void deplacerSnake(){
		xPos += xDeplacement;
		yPos += yDeplacement;
	}

	void tournerHaut(){
		xDeplacement=0; 
		yDeplacement=-Fenetre.tailleCase;
	}

	void tournerBas(){
		xDeplacement=0; 
		yDeplacement=Fenetre.tailleCase;
	}

	void tournerDroite(){
		xDeplacement=Fenetre.tailleCase; 
		yDeplacement=0;
	}

	void tournerGauche(){
		xDeplacement=-Fenetre.tailleCase; 
		yDeplacement=0;
	}

	/**
	 * méthode permetant de tester la colision des joueurs avec lui-même, avec l'autre joueur ou avec les bords
	 * de la fenêtre
	 * @return true si collision
	 */

	boolean testCollisionSnake(){
		try {
			if (xPos<=0 || xPos>50 * Fenetre.tailleCase || yPos<=0 || yPos>50 * Fenetre.tailleCase) {return true;} 
			else if (fenetre.occupe[xPos][yPos]){return true;}
			else {return false;}
		} catch (ArrayIndexOutOfBoundsException e){
			
			return true;}
	}

}

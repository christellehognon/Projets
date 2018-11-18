package tron;

import processing.core.PApplet;
import processing.core.PImage;

import java.awt.Color;

public class Fenetre extends PApplet {

	static final int tailleCase = 15; // nombre de pixels pour la largeur/hauteur d'une case
	
	static int NB_LIGNES = 50;
	static int NB_COLONNES = 50;
	static final String auteurs = "Christelle Libouban, Jerome Le Carrou, Jean Robertou"; // les auteurs
	
	public Color ROUGE = new Color(255,0,0);
	public Color BLEU = new Color(0,0,255);
	public Color NOIR = new Color(0,0,0);
	public Color VERT = new Color(0,255,0);
	
	Snake snake1 = new Snake ("Player 1",195,345,ROUGE,this,tailleCase,0); //deplacement x initial positif (vers la droite) et pas de deplacement y
	Snake snake2 = new Snake ("Player 2",555,345,BLEU,this,-tailleCase,0);  //deplacement y initial negatif (vers la gauche) et pas de deplacement y
	
	//tableau des positions occupees par les snakes
	boolean[][] occupe = new boolean[52* tailleCase][52* tailleCase];
	
	//definition d'un type Phase avec 3 constantes
	//la phase par défaut (au démarrage du jeu) est le menu
	enum Phase {MENU,JEU,FIN}
	Phase phase_courante = Phase.MENU;
	
	//boutons de navigation
	/*Bouton bouton_menu = new Bouton(200, 300, "Menu",bouton_fond_Color,bouton_texte_Color,this);*/
	Bouton bouton_demarrer = new Bouton(200, 650, "Start",NOIR,VERT,this);
	Bouton bouton_quitter = new Bouton(200, 700, "Quit",NOIR,VERT,this);
	
	PImage imgMenu;
	PImage imgFin;
	
	public void settings() {
		size(52 * tailleCase, 52 * tailleCase, P2D); // mode 2d
 	}
	
	/**
	 * méthode setup charge les images de menu et fin de jeu
	 */
	public void setup() {
		imgMenu = loadImage("TronMotoLightCycle.jpg");
		imgFin = loadImage("snake.jpg");
		frameRate(4); // 4 images par seconde
		surface.setTitle("Mini-projet : Tron par "+ auteurs); // titre de la fenêtre
	}

	/**
	 * 3 phases de jeu
	 * Menu : affiche les boutons de navigation "Démarrer" et "quitter"
	 * Jeu : lance le jeu
	 * Fin :  affiche "GAME OVER"
	 */
	public void draw() {
	
		switch(phase_courante){
		case  MENU:
			background(0);
			image(imgMenu,65,50);
			fill(0);
			noStroke();
		    fill(0,255,0);
		    textSize(100);
		    textAlign(CENTER, CENTER);
		    text("TRON", 400, 500);
			bouton_demarrer.dessiner();
			bouton_quitter.dessiner();
			break;
			
		case JEU:
			snake1.dessinerSnake();
			snake2.dessinerSnake();
			snake1.deplacerSnake();
			snake2.deplacerSnake();
		
			
			/**
			 * appel de la méthode 'testCollisionSnake' de la classe Snake
			 * si snake1 touche un bord ou passe sur une posistion occupee, arret du jeu
			 * 
			 */
			if (snake1.testCollisionSnake()){
				background(0);
				phase_courante = Phase.FIN;
			}
			if (snake2.testCollisionSnake()){
				background(0);
				phase_courante = Phase.FIN;
			}
			
			//une position devient occupee
			occupe[snake1.getxPos()][snake1.getyPos()] = true;
			occupe[snake2.getxPos()][snake2.getyPos()] = true;
			break;
			
		case FIN:
			image(imgFin,-10,200);
			fill(0);
			noStroke();
			fill(0,255,0);   
			textSize(48);
			textAlign(CENTER,CENTER);
			text("GAME OVER", 400, 500);
			snake1.setxDeplacement(0);
			snake1.setyDeplacement(0);
			snake2.setxDeplacement(0);
			snake2.setyDeplacement(0);
			noLoop();
			break;
		}
	}
	
	/**
	 * méthode permet de naviguer dans le jeu
	 * click sur le bouton "Start" lance le jeu
	 * click sur le bouton "Quit" ferme le jeu
	 */
	public void mousePressed(){
		if(bouton_demarrer.contient_souris()){
			background(0);
			dessiner_grille();
			phase_courante = Phase.JEU;
		}
		if(bouton_quitter.contient_souris()){
			exit();
		}
	}
	
	/**
	 * permet de diriger les 2 joueurs au clavier
	 * appelle de méthodes la classe "Snake"
	 */
	public void keyPressed() {
		
		//deplacement joueur 1
		if (key == 'z'){snake1.tournerHaut();}
		if (key == 's'){snake1.tournerBas();}
		if (key == 'q'){snake1.tournerGauche();}
		if (key == 'd'){snake1.tournerDroite();}
		
		//deplacement joueur 2
		if (keyCode == UP){snake2.tournerHaut();}
		if (keyCode == DOWN){snake2.tournerBas();}
		if (keyCode == LEFT){snake2.tournerGauche();}
		if (keyCode == RIGHT){snake2.tournerDroite();}
	}
	
	/**
	 * dessine la grille en fond de jeu (50 cases sur 50 cases)
	 */
	public void dessiner_grille() {
		  int x0=15;
		  int y0=15;
		  for (int i=0; i<NB_LIGNES; i++) {
		    for (int j=0; j<NB_COLONNES; j++) {
		      stroke(0,255,0);  //vert
		      strokeWeight(1); //largeur trait case
		      fill(0);
		      rect(x0+i*tailleCase, y0+j*tailleCase, tailleCase, tailleCase); 
		    }
		  }
		}
	
	public static void main(String[] args) {
		PApplet.main("tron.Fenetre");		

	}

}

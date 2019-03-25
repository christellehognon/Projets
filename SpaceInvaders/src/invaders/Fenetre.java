package invaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import modele.AInvaders;
import modele.Bouclier;
import modele.DeplacementBouclier;
import modele.DeplacementCercle;
import modele.DeplacementEscalier;
import modele.DeplacementMissile;
import modele.DeplacementMissileEnnemi;
import modele.DeplacementVaisseau;
import modele.IDeplacement;
import modele.Invader;
import modele.Missile;
import modele.MissileEnnemi;
import modele.Point;
import modele.Vaisseau;

import Vue.Bouton;
import Vue.Dessin1;
import Vue.Dessin2;
import Vue.Dessin3;
import Vue.DessinBouclier;
import Vue.DessinMissile;
import Vue.DessinMissileEnnemi;
import Vue.VaisseauDessin;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Mini projet Space Invader
 * Alexis Calabro et Christelle Hognon
 * 
 */

public class Fenetre extends PApplet {

	PImage fond;
	Collection<AInvaders> invaders = new ArrayList<AInvaders>();
	Collection<Missile> missiles = new ArrayList<Missile>();
	Collection<MissileEnnemi> missileEnnemi = new ArrayList<MissileEnnemi>();
	Collection<AInvaders> boucliers = new ArrayList<AInvaders>();

	Collection<AInvaders> invadersASupprimer = new ArrayList<AInvaders>();
	Collection<Missile> missilesASupprimer = new ArrayList<Missile>();
	Collection<MissileEnnemi> missileEnnemiASupprimer = new ArrayList<MissileEnnemi>();
	Collection<AInvaders> boucliersASupprimer = new ArrayList<AInvaders>();
	public Vaisseau joueur;

	private int decompte = 0;
	private double positionEnnemiX;
	private double positionEnnemiY;
	private boolean gagnant=false;

	public enum Phases {Menu, Jeu, Fin};
	Phases etape = Phases.Menu;

	PImage logo;
	PImage imgMenu;

	//Création du bouton démarrer
	Bouton on = new Bouton(this, 412, 600, "START");

	public void settings(){
		size(1024, 768);
	}





	public void setup(){
		frameRate(60);
		fond = loadImage("universFond.jpg");
		imgMenu = loadImage("SpaceInvadersLogo.png");
		Point pointVaisseau = new Point(512, 700);		
		int Xdep = 300;
		int Ydep = 300;



		//instancie les invaders en cercle et les ajoute dans l'arraylist invaders
		for (int i = 0; i < 4; i++ ){				
			IDeplacement cercle = new DeplacementCercle(new Point (Xdep, Ydep), 2*i* Math.PI/4);
			invaders.add(new Invader(new Dessin2(this, cercle), cercle));
		}
		for (int i = 0; i < 4; i++ ){				
			IDeplacement cercle = new DeplacementCercle(new Point (Xdep, Ydep), (2*i + 1)* Math.PI/4);
			invaders.add(new Invader(new Dessin1(this, cercle), cercle));	
		}



		//instancie le deplacement du vaisseau
		DeplacementVaisseau depV = new DeplacementVaisseau(pointVaisseau);

		//instancie le dessin du vaisseau
		VaisseauDessin des3 = new VaisseauDessin(this, depV);

		//instancie le Vaisseau
		joueur =  new Vaisseau(des3, depV);


		invaders.add(joueur);



		//instancie le déplacement en escalier, le dessin3, les invaders et les ajoute en même temps dans l'arraylist invaders (ce qui nous épargne beaucoup de lignes de code!!!)
		for (int i = 0; i < 20; i++){
			IDeplacement escalier = new DeplacementEscalier(new Point (-i * 90, 0 ));
			invaders.add(new Invader(new Dessin3(this, escalier), escalier));
		}
		// crée les boucliers
		for (int i = 0; i <= 7; i++){
			IDeplacement bouclierDep = new DeplacementBouclier(new Point(i * 120 + 70, 600));
			boucliers.add(new Invader(new DessinBouclier(this, bouclierDep), bouclierDep));
		}

	}

	public void draw(){

		switch(etape){
		case Menu:
			image(fond, 0, 0);
			image(imgMenu,100,50);
			imgMenu.resize(400, 300);
			fill(255,255,0);
			text("Christelle et Alexis",200,700);
			textSize(200);
			textAlign(CENTER, CENTER);
			on.dessiner();
			break;
		case Jeu:
			decompte++;
			image(fond, 0, 0);
			Random r = new Random();
			int index = r.nextInt(invaders.size());
			int i = 0; 
			for(AInvaders v : invaders){
				i++;
				v.dessiner();
				v.deplacer();
				if (index == i && v.getDirection() != -1 && decompte > 30){
					positionEnnemiX = v.getPoint().getX();
					positionEnnemiY = v.getPoint().getY();
					tirerEnnemi();
					decompte = 0;
				}

			}
			
			//Dessine les boucliers
			for (AInvaders bou : boucliers){
				bou.dessiner();
			}
			
			//Dessine les missiles ennemis et les déplacent
			for (MissileEnnemi me : missileEnnemi){
				me.dessiner();
				me.deplacer();
			}

			//Dessine les missiles du vaisseau et les déplaçent
			for (Missile m : missiles){
				m.dessiner();
				m.deplacer();
			}

			// collision entre missileEnnemi et joueur		

			for(MissileEnnemi me : missileEnnemi){			
				if (me.collision(joueur) && me.getDirection() != joueur.getDirection()){
					missileEnnemiASupprimer.add(me);
					invadersASupprimer.add(joueur);	
					etape = Phases.Fin;
				}

			}
			//collision entre missileEnnemi et bouclier 
			for(MissileEnnemi me : missileEnnemi){	
				for(AInvaders bou : boucliers ){
					if (me.collision(bou) && me.getDirection() != joueur.getDirection()){
						missileEnnemiASupprimer.add(me);
						boucliersASupprimer.add(bou);				
					}
				}


			}

			// collision entre missile et invaders
			for (Missile m : missiles){
				for (AInvaders a : invaders){
					if (m.collision(a) && m.getDirection() != a.getDirection())
					{
						missilesASupprimer.add(m);
						invadersASupprimer.add(a);
						//System.out.println("invaders largeur : " + a.getLargeur() + " " + a.toString());
						//System.out.println("invaders hauteur : " +a.getHauteur());
					}

				}
				if (m.getPoint().getY() + m.getHauteur() <= 0){
					missilesASupprimer.add(m);
					//System.out.println("missile hauteur : " +m.getHauteur());
					//System.out.println("missile direction" +m.getDirection());
					//System.out.println("invaders direction" +a.getDirection());
				}
			}

			//collision entre missile et bouclier 
			for(Missile m : missiles){	
				for(AInvaders bou : boucliers ){
					if (m.collision(bou)){
						missilesASupprimer.add(m);
						boucliersASupprimer.add(bou);				
					}
				}


			}
			boucliers.removeAll(boucliersASupprimer);
			missileEnnemi.removeAll(missileEnnemiASupprimer);
			missiles.removeAll(missilesASupprimer);
			invaders.removeAll(invadersASupprimer);
			if  ( invaders.size() == 1){
				gagnant = true;
				etape = Phases.Fin;
			}
			break;
		case Fin:
			fill(255, 255, 0);
			textSize(80);
			textAlign(CENTER,CENTER);
			text("GAME OVER", 500, 400);
			if (gagnant == false){
				textSize(60);
				textAlign(CENTER, CENTER);
				text("Vous avez perdu !", 500, 500);
			}
			if (gagnant == true){
				textSize(60);
				textAlign(CENTER, CENTER);
				text("Vous avez gagné !", 500, 500);
			}
			break;
		}

	}



	public void keyPressed() {

		//Pour le vaisseau

		switch(key){
		case 'd':
			joueur.setPas(14);
			joueur.deplacer();
			break;
		case 'q':
			joueur.setPas(-14);
			joueur.deplacer();
			break;
		case 'l':				
			tirer();
			break;    
		}

	}
	
	public void mousePressed(){
		
		if(on.contientSouris()){
			image(fond, 0, 0);
			etape = Phases.Jeu;
		}
	}

	public void tirer() {
		DeplacementMissile missileDep = new DeplacementMissile (new Point (joueur.getPoint().getX(), joueur.getPoint().getY()));	
		missiles.add(new Missile (new DessinMissile(this, missileDep), missileDep));	

	}

	public void tirerEnnemi(){
		DeplacementMissileEnnemi missileEnnemiDep = new DeplacementMissileEnnemi (new Point (positionEnnemiX, positionEnnemiY));		
		missileEnnemi.add(new MissileEnnemi (new DessinMissileEnnemi(this, missileEnnemiDep), missileEnnemiDep));

	}

	public static void main(String[] args) {


		PApplet.main("invaders.Fenetre");

	}

}

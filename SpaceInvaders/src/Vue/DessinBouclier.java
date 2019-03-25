package Vue;

import modele.IDeplacement;
import processing.core.PApplet;

public class DessinBouclier extends ADessin{	 

		public DessinBouclier(PApplet fenetre, IDeplacement deplacement) {
		super(fenetre, deplacement);
		image = fenetre.loadImage("bouclier.png");
		image.resize(70, 0);
	}

		@Override
		public int hauteur() {
			
			return image.height;
		}

		@Override
		public int largeur() {
			
			return image.width;
		}	
		
}

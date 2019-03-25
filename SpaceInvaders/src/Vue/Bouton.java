package Vue;

import invaders.Fenetre;

public class Bouton {
	  private Fenetre fen;
	  private int x,y;
	  private String texte;
	  private int w = 180;
	  private int h = 75;
	  
	 public Bouton(Fenetre fen,int xx, int yy, String t)
	 {
	    x = xx;
	    y = yy;
	    texte = t;
	    this.fen = fen;
	  }
	  public void dessiner(){
	    float xc = x + w/2;
	    float yc = y + h/2;
	    fen.fill(255, 255, 0);
	    fen.rect(x, y, w, h, 10, 10, 10, 10);
	    fen.textAlign(fen.CENTER, fen.CENTER);
	    fen.textSize(40);
	    fen.fill(255);
	    fen.text(texte, xc ,yc);
	  }

	  public boolean contientSouris(){
	    return ( x<=fen.mouseX && fen.mouseX<=x+w && y<=fen.mouseY && fen.mouseY<=y+h);
	  }
}

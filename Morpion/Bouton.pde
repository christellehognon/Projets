public class Bouton
{
  
  float x,y;
  String texte;
  float largeur = 100;
  float hauteur = 50;
  int angle = 12;

  Bouton(float xb, float yb, String t){   
    x = xb;
    y = yb;
    texte = t;
  }
  public void dessinerBouton(){
    float xc = x + largeur/2;
    float yc = y + hauteur/2;
    fill(120, 50, 120);
    rect(x, y, largeur, hauteur, angle, angle, angle, angle);//dessine un rectangle aux coins arrondis
    textAlign(CENTER, CENTER);
    textSize(20);
    fill(255);
    text(texte, xc ,yc);
  }
  public boolean contientSouris(){
    return ( x<=mouseX && mouseX<=x+largeur && y<=mouseY && mouseY<=y+hauteur); 
  }
}

//Attributs
final float decalageOrigine = 100;
int nbCases = 5;
float tailleCase = (int)((800 - (decalageOrigine * 2))/nbCases);
int compteur=0;
int compteurAgrandissement=0;
int[][] tableauJeu = new int[nbCases][nbCases];
float centreCase = tailleCase/2;

int joueur1 = 1;
int joueur2 = 2;
int joueurCourant = joueur1;

int [] depX ={1, 1, 0, -1, -1, -1, 0, 1};
int [] depY = {0, 1, 1, 1, 0, -1, -1, -1};


boolean finPartie = false;

PImage photo;

//Création des boutons
Bouton on = new Bouton(100, 30, "Démarrer");
Bouton off = new Bouton(600, 30, "Arrêter");
Bouton exit = new Bouton(350, 30, "Retour");

// Phases de jeu
enum Phases {
  Menu, Jeu, Fin
};
Phases etape = Phases.Menu;

void setup() 
{
  size(800, 800);
  photo = loadImage("morpion.jpg");
  joueurCourant = int(random(1, 3));
}

void draw() 
{
  background(200);
  switch(etape) {
    
  case Menu:
    on.dessinerBouton();
    off.dessinerBouton();
    image(photo, 100, 100);
    textSize(80);
    text("Morpion", 400, 740);
    textAlign (CENTER);
    break;
    
  case Jeu:
    //si coup gagnant etape = Phases.Fin
    exit.dessinerBouton();
    dessinerGrille();
    if (sourisDansGrille()){
      curseur();
    } else { cursor();}
    break;
    
  case Fin:
    cursor();
    exit.dessinerBouton();
    afficherGagnant();
    break;
  }
}

public void dessinerGrille(){
  for (int i=0; i<nbCases; i++){
    for (int j=0; j<nbCases; j++){
      fill(230,220,230);
      rect(decalageOrigine +i * tailleCase, decalageOrigine + j * tailleCase, tailleCase, tailleCase);
      afficherPion(i,j);  
  }
  }
}

public void agrandirGrille() 
{ 
  if (compteurAgrandissement < 6)
  {
    int[][] nouvTableauJeu = new int[nbCases + 2][nbCases + 2];
  
    for (int i=0; i<nbCases; i++) {
      for (int j=0; j<nbCases; j++) {
        nouvTableauJeu[i + 1][j + 1] = tableauJeu[i][j];
      }
    }
    tableauJeu = nouvTableauJeu;
    nbCases+= 2;
    tailleCase = (float)((width - (decalageOrigine* 2)) / nbCases);
    centreCase = tailleCase/2;
  }
}

public void mousePressed() 
{
  int x = floor(map(mouseX, decalageOrigine, (width - (decalageOrigine)), 0, nbCases));
  int y = floor(map(mouseY, decalageOrigine, (height - (decalageOrigine)), 0, nbCases));
  if (on.contientSouris() && etape == Phases.Menu) {
      etape = Phases.Jeu;
      initialisationJeu();
  }
  if (off.contientSouris()&& etape == Phases.Menu) {
    exit();
  }
  if (exit.contientSouris()&& (etape == Phases.Jeu || etape == Phases.Fin)) {
      etape = Phases.Menu;
  }
  if (dansGrille(x,y) && etape == Phases.Jeu)
  {
    if(compteur == 0 || caseValide(x,y)){
      if(!caseVide(x,y))
      {
        fill(255, 0, 0);
        rect(decalageOrigine + x * tailleCase, decalageOrigine + y * tailleCase,  tailleCase, tailleCase);
      }else 
      {
        changerJoueurCourant(); 
        ajouterPion(x,y);
      }
    }
  }
}
public void ajouterPion(int x, int y) 
{
   if (compteur == 0 || caseValide(x,y))
     {
        if(tableauJeu[x][y] == 0)
        {
          if (compteur % 2 != 0)
            {
              tableauJeu [x][y] = 1; 
            } 
          else {
               tableauJeu[x][y] = 2;
            }
            compteur++;
          finPartie = rechercheAlignement(x, y, joueurCourant);
          if (finPartie || compteur == (nbCases*nbCases)-1) {
      //if (finPartie)
              etape = Phases.Fin;
          }
       
        if ((x == 0) || (x == nbCases-1) || (y == 0) || (y == nbCases-1))
        {
          agrandirGrille();
          compteurAgrandissement ++;
        }
        }
        
     }
  } 


/*public void ajouterPion(int x, int y) 
{
   if (compteur == 0 || caseVide(x,y) || caseValide(x,y))
   {
      if(tableauJeu[x][y] == 0)
      {
        tableauJeu[x][y] = joueurCourant;
        finPartie = rechercheAlignement(x, y, joueurCourant);
        if (finPartie || compteur == (nbCases*nbCases)-1) {
          etape = Phases.Fin;
        }
      compteur++;
      if ((x == 0) || (x == nbCases-1) || (y == 0) || (y == nbCases-1))
        {
          agrandirGrille();
        }
      }
   }
}*/

public void afficherPion(int x, int y)
{
    
      if(tableauJeu [x][y] == 1)
        {
          fill(0);
          ellipse(decalageOrigine + x*tailleCase + centreCase, decalageOrigine + y*tailleCase + centreCase, tailleCase*0.75, tailleCase*0.75);
        }
       else if(tableauJeu [x][y] == 2)
        {
          fill(255);
          ellipse(decalageOrigine + x*tailleCase + centreCase, decalageOrigine + y*tailleCase + centreCase, tailleCase*0.75, tailleCase*0.75);
        }
}

public boolean caseVide(int x, int y)
{
    if(tableauJeu[x][y] == 0){
      return true;
    }
      return false;
}

public boolean caseValide(int x, int y){
  for (int i=0; i<8; i++) {
    int xDep = x + depX[i];
    int yDep = y + depY[i];
    if (dansGrille(xDep, yDep)) {
      if (tableauJeu[xDep][yDep] != 0) {
        return true;
      }
    }
  }
  return false;
}

public void curseur()
{
  noCursor();
  if(compteur % 2 != 0) {
    fill(0);
  } 
  else {
     fill(255);
  }
  ellipse(mouseX, mouseY,  tailleCase*0.75, tailleCase*0.75);
}
public boolean dansGrille(int x, int y) {
  return ((x >= 0) && (x < nbCases) && (y >= 0) && (y < nbCases));
}

public boolean sourisDansGrille()
{
  return (mouseX > decalageOrigine && mouseX<800 - decalageOrigine && mouseY > decalageOrigine && mouseY<800 - decalageOrigine);
}

public void initialisationJeu(){
  int[][] tableauJeu1 = new int[nbCases][nbCases];
  tableauJeu = tableauJeu1;
  compteur = 0;
  nbCases = 5;
  tailleCase = ((800 - (decalageOrigine * 2))/nbCases);
  centreCase = tailleCase/2;
}

public boolean rechercheAlignement(int x, int y, int joueurCourant) {
  // Stock les résultats des différentes directions
  int[] alignements = new int[8];

  // Déplacement dans les 8 directions
  for (int dep=0; dep<8; dep++) {
    int newX = x;
    int newY = y;
    // Vérifies jusqu'à 4 pions
    for (int i=0; i<4; i++) {
      // Calcul des nouvelles positions
      newX += depX[dep];
      newY += depY[dep];
      // Test si la nouvelle position est dans la grille et correspond à joueurCourant
      if (dansGrille(newX, newY) && tableauJeu[newX][newY] == joueurCourant) {
        alignements[dep]++;
      }
      // Sinon passe à la position suivante
      else {
        break;
      }
    }
  } 
  // Parcours la liste des alignements et calcul si le dernier pion joué est gagnant
  for (int j=0; j<4; j++) {
    if (alignements[j] + alignements[j+4] >= 4) {
      return true;
    }
  }

  // Pas de gagnant à partir du dernier pion joué
  return false;
}

void changerJoueurCourant() {
   // Changement de joueur courant
  if (joueurCourant == 1) {
    joueurCourant = joueur2;
  } else if (joueurCourant == 2) {
    joueurCourant = joueur1;
  }
}

public void afficherGagnant()
{
  if (joueurCourant == 2 ){
     fill(255);
    textSize(50);
    text("Le gagnant est le Joueur 1", 400, 300);
    textAlign (CENTER);
  } else if (joueurCourant == 1 ){
    fill(0);
    textSize(50);
    text("Le gagnant est le Joueur 2", 400, 300);
    textAlign (CENTER);
  }/*else {
      fill(255);
      textSize(50);
      text("Pas de gagnant", 400, 300);
  }*/
}

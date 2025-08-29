/* Zweck: Einführung in Methoden
 * Autor: Franz Breunig, Oktober 2021
 */
 
// globale Variable (die sind in jeder Methode verfügbar)
int w = 100;  // Flaggenbreite
int h = 60;   // Flaggenhöhe
int b = h/5;  // Zwischenraum

int white = color(255);
int black = color(0);
int red   = color(255, 0, 0);


// Wird ein einziges Mal aufgerufen und das vor dem draw
void setup() {
  size(800, 600);
}

// Berechnet die x-Position zu einer Spalten-Nummer
//
// Beachte bei Methoden:
// *) ganz links steht der Rückgabetyp, falls nix zurück gegeben werden soll, 
//    steht dann statt des Typs nur "void"
// *) getX ist der Name der Methode (= Unterprogramm-Name)
// *) in runden Klammern stehen die Paramter, bei mehreren durch Beistrich getrennt
//    -) vor dem Parametername steht immer sein Typ
//    -) die runden Klammern können auch leer sein, wenn kein Parameter gebraucht wird
// *) der eigentlich Code des Unterprogramms steht zwischen geschwungenen Klammern
int getX(int col) {
  int x = col*b + col*w + b/2;
  
  return x; // beendet die Methode und gibt den berechneten Wert zurück
}

// Berechnet die y-Position zu einer Zeilen-Nummer
int getY(int row) {
  return row*b + row*h + b/2;
}

// Zeichnet die Österreich-Flagge in die gewünschte Spalte und Zeile
void drawFlagAustria(int col, int row) {
  int x = getX(col);
  int y = getY(row);
  int d = h/3;
  
  fill(red);
  rect(x, y, w, h);
  
  fill(white);
  rect(x, y+d, w, d);
  
}

// wird ca. 60x pro Sekunde aufgerufen
void draw() {
  drawFlagAustria(0, 0);
  drawFlagAustria(1, 1);
  drawFlagAustria(2, 0);
}

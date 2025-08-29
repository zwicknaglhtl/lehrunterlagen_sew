
int direction=1;
int speed = 2;

int x = 50;  //Startposition
int y=200;

final int DIAMETER_CIRCLE=30;

//setup() wird einmal beim Programmstart aufgerufen
void setup() {
  size(400, 400);
}

//draw() wird 60 mal pro Sekunde aufgerufen
void draw() {

  background(102);   //"löscht" das gesamte Zeichenfeld

  circle(x, y, DIAMETER_CIRCLE);

  //ändere die Richtung jeweils an den Grenzen des Zeichenfelds
  if (x>400-DIAMETER_CIRCLE/2 || x<0+DIAMETER_CIRCLE/2) {
    direction = direction * -1;
  }

  x = x+speed*direction;  //setze x neu für den nächsten Aufruf von draw()
}

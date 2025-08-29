int x = 200;   //globale Variablen -> überall
int y = 200;   //in jeder Methode verfügbar (sichtbar)
int r = 50;

void setup() {
  size(800, 800);

  noFill();

  drawSymbol();

  x=400;
  y=600;
  r=80;

  drawSymbol();

  x=600;
  y=100;
  r=20;

  drawSymbol();

  x=200;
  y=500;
  r=60;

  drawSymbol();
}

void drawSymbol() {  //Methode definieren
  rect(x-r, y-r, 2*r, 2*r);
  ellipse(x, y, 2*r, 2*r);
  line(x, y-r, x, y+r);
  line(x+r, y, x-r, y);
}

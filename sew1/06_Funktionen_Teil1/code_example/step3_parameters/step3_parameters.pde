void setup() {
  size(800, 800);

  noFill();

  drawSymbol(200,200,50);
  drawSymbol(400,600,80);
  drawSymbol(600,100,20);
  drawSymbol(200,500,60);
}

void drawSymbol(int x,int y,int r) {  //Methode definieren
  rect(x-r, y-r, 2*r, 2*r);
  ellipse(x, y, 2*r, 2*r);
  line(x, y-r, x, y+r);
  line(x+r, y, x-r, y);
}

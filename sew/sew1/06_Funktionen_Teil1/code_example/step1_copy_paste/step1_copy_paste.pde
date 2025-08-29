int x = 200;
int y = 200;
int r = 50;

size(800, 800);

noFill();

rect(x-r, y-r, 2*r, 2*r);
ellipse(x, y, 2*r, 2*r);
line(x, y-r, x, y+r);
line(x+r, y, x-r, y);

x=400;
y=600;
r=80;

rect(x-r, y-r, 2*r, 2*r);
ellipse(x, y, 2*r, 2*r);
line(x, y-r, x, y+r);
line(x+r, y, x-r, y);

x=600;
y=100;
r=20;

rect(x-r, y-r, 2*r, 2*r);
ellipse(x, y, 2*r, 2*r);
line(x, y-r, x, y+r);
line(x+r, y, x-r, y);

x=200;
y=500;
r=60;

rect(x-r, y-r, 2*r, 2*r);
ellipse(x, y, 2*r, 2*r);
line(x, y-r, x, y+r);
line(x+r, y, x-r, y);

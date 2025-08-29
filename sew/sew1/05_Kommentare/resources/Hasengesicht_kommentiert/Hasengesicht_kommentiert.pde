/*
Reinhold Buchinger

Ein Hasengesicht
*/

size(400,400);

int groesseAugen = 10;
int breiteOhren = 60;
int hoeheOhren = 120;

ellipse(150, 70, breiteOhren, hoeheOhren);  // linkes Ohr
ellipse(240, 70, breiteOhren, hoeheOhren);  // rechtes Ohr

ellipse(200, 170, 150, 150);    // Gesicht

fill(0, 0, 0);
ellipse(170, 150, groesseAugen, groesseAugen);  // linkes Auge
ellipse(230, 150, groesseAugen, groesseAugen);  // rechtes Auge

line(150, 200, 250, 200);   // Mund

noFill();
rect(185, 200, 15, 10); // linker Zahn
rect(200, 200, 15, 10); // rechter Zahn

# Theorie

## Beispiel

Wir haben ein Rechteck mit `a = 300 cm` und `b = 200 cm`. Damit kann man
leicht die Fläche ausrechnen.

Im *wirklichen* Leben werden die Längen
gemessen und sind deshalb mit einem Messfehler behaftet: Wir haben also ein
Rechteck mit `a = 300 `\textpm` 5 cm` und `b = 200 `\textpm` 3 cm`. Wie
groß ist die Fläche dieses Rechtecks? Die *mittlere*
Fläche^[wobei das eigentlich nicht $300*200 cm^2$ sind] ist wieder leicht
auszurechnen, aber wie groß ist der Fehler?

## Formeln

Wir speichern den Wert als `x` und den Fehler $\Delta x$ als `dx` -- wobei `dx` immer
positiv ist.

### Summe

Der Fehler der Summe ist die Summe der Fehler^[die Theorie zu diesen Formeln erklärt Ihnen ein freundlicher Mathematiklehrer -- leider
braucht man dazu Dinge die weit über den Stoff des 2-ten Jahrgangs hinausgehen... siehe https://de.wikipedia.org/wiki/Fehlerfortpflanzung ].

\\[ (x_1 \pm dx_1)  +  (x_2 \pm dx_2) =  (x_1 + x_2)  \pm (dx_1 + dx_2) \\]

### Differenz

Der Fehler der Differenz ist die **Summe** der Fehler.

\\[ (x_1 \pm dx_1)  -  (x_2 \pm dx_2) =  (x_1 - x_2)  \pm (dx_1 + dx_2) \\]

### Produkt

Der Fehler des Produkts ist die Summe des Betrags aus "ein Wert mal anderer Fehler".

\\[ (x_1 \pm dx_1)  \cdot  (x_2 \pm dx_2) =
              (x_1 \cdot x_2)  \pm (|x_1 \cdot dx_2| + | x_2 \cdot dx_1|) \\]

Hinweis: den Betrag einer Zahl ( $|x|$ ) kann man mit ```Math.abs(x)``` berechnen.

### Quotient

\\[ \frac{x_1 \pm dx_1}{x_2 \pm dx_2} =
         \frac{x_1}{x_2} \pm \frac{(|x_1 \cdot dx_2| + |x_2 \cdot dx_1|)}{x_2^2} \\]

<!--

### Wurzel

const udouble sqrt(const udouble x)
{
  double erg = sqrt(x.get_x());
  if (erg != 0)
    return udouble( erg, x.get_dx()/2/erg);
  else
    return udouble( 0, DBL_MAX); // ???
}

-->

## Achtung

1) Die Formeln gelten nur bei unabhängigen (Mess-)Fehlern.

    Gegenbeispiel: wenn man einen Stab mit genau `200 cm` *ungefähr* in der Mitte
    abbricht dann ist jeder Teil `100 `\textpm` 10 cm` lang. Die Summe dieser
    beiden Teile ist aber nicht `200 `\textpm` 20 cm` lang.

2) Die Formeln gelten nur bei *kleinen* Fehlern dh. $dx1\cdot dx2$ ist vernachlässigbar klein.

# Musterlösung: Übungsaufgaben zu Arrays

## Aufgabe 1: Array-Deklaration und Initialisierung

### a) Deklaration des `preise`-Arrays:
```java
float[] preise = {1.0f, 234.0f, 7.0f, 42.5f};
```

### b) Deklaration des `farben`-Arrays:
```java
String[] farben = {"rot", "grün", "hellblau"};
```

---

## Aufgabe 2: Zugriff auf Array-Elemente

Gegebenes Array:
```java
int[] noten = {1, 2, 3, 4, 5};
```

### a) Wert von `noten[0]`:
**Antwort:** `1`

### b) Wert von `noten[4]`:
**Antwort:** `5`

### c) Ausgabe von `System.out.println(noten[1] + noten[2]);`
**Berechnung:** `2 + 3 = 5`
**Ausgabe:** `5`

---

## Aufgabe 3: Array-Länge

Gegebenes Array:
```java
String[] wochentage = {"Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"};
```

### a) Anzahl der Elemente:
**Antwort:** `7`

### b) Höchster gültiger Index:
**Antwort:** `6` (da Indizes bei 0 beginnen)

---

## Aufgabe 4: Array-Manipulation

Gegebenes Array:
```java
String[] speisen = {"Pizza", "Lasagne", "Gnocchi"};
```

### a) Ersetzen von "Lasagne" durch "Spaghetti":
```java
speisen[1] = "Spaghetti";
```

### b) Hinzufügen von "Salat" (Achtung: Arrays sind in Java nicht dynamisch!)
```java
String[] neueSpeisen = new String[speisen.length + 1];
for (int i = 0; i < speisen.length; i++) {
    neueSpeisen[i] = speisen[i];
}
neueSpeisen[speisen.length] = "Salat";
speisen = neueSpeisen;
```

**Alternative:** Nutzung von `Arrays.copyOf`:
```java
import java.util.Arrays;
speisen = Arrays.copyOf(speisen, speisen.length + 1);
speisen[speisen.length - 1] = "Salat";
```

---

## Aufgabe 5: Methoden mit Arrays

### a) Methode zur Berechnung der Summe eines Arrays:
```java
public static int summe(int[] zahlen) {
    int summe = 0;
    for (int zahl : zahlen) {
        summe += zahl;
    }
    return summe;
}
```

### b) Aufruf der Methode mit `werte = {3, 5, 7, 9}`:
```java
int[] werte = {3, 5, 7, 9};
int ergebnis = summe(werte);
System.out.println("Summe: " + ergebnis);
```

**Ausgabe:** `Summe: 24`

---

## Aufgabe 6: Array und Schleifen

### Programm zur Erstellung eines Arrays mit Quadratzahlen:
```java
public class QuadrateArray {
    public static void main(String[] args) {
        int[] quadrate = new int[10];
        for (int i = 0; i < quadrate.length; i++) {
            quadrate[i] = i * i;
        }
        for (int zahl : quadrate) {
            System.out.println(zahl);
        }
    }
}
```

**Ausgabe:**
```
0
1
4
9
16
25
36
49
64
81
```

---

**Ende der Musterlösung**


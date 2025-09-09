# Lösungsblatt: Grundlagen Programmieren in Java

---

## 1. Datentypen

**Aufgabe 1:**  
```java
int alter = 25;                  // Alter als int
double buchPreis = 12.99;        // Preis als double
String vorname = "Max";          // Text als String
boolean javaErfahrung = true;    // Wahrheitswert als boolean
```

**Aufgabe 2:**  
```java
double zahl = 10.0;
int zahlInt = (int) zahl;
System.out.println(zahlInt); // Ausgabe: 10
```

---

## 2. Funktionen (Methoden)

**Aufgabe 3:**  
```java
public static int addiere(int a, int b) {
    return a + b;
}

public static void main(String[] args) {
    int ergebnis = addiere(5, 7);
    System.out.println(ergebnis); // Ausgabe: 12
}
```

**Aufgabe 4:**  
```java
public static boolean istGerade(int zahl) {
    return zahl % 2 == 0;
}

public static void main(String[] args) {
    System.out.println(istGerade(4)); // true
    System.out.println(istGerade(7)); // false
}
```

---

## 3. Bedingungen

**Aufgabe 5:**  
```java
public static String pruefeZahl(int zahl) {
    if (zahl > 0) {
        return "1";
    } else if (zahl < 0) {
        return "-1";
    } else {
        return "0";
    }
}
```

**Aufgabe 6:**  
1. „Die Zahl `x` ist größer als 10 und kleiner als 20.“
```java
(x > 10 && x < 20)

```

2. „Die Zahl `y` ist entweder gerade oder negativ.“  
```java
(y % 2 == 0 || y < 0)

```

3. „Die Zahl `z` ist nicht gleich 0.“  
```java
(z != 0)
```

4. „Der String `name` ist gleich `"Max"` und das Alter ist mindestens 18.“  
```java
(name.equals("Max") && alter >= 18)

```

5. „Die Temperatur `t` ist unter 0 oder über 30.“  
```java
(t < 0 || t > 30)
```

---

## 4. Schleifen

**Aufgabe 7:**  
```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}

```

**Aufgabe 8:**  
```java
int summe = 0;
int i = 1;

while (i <= 100) {
    summe += i;
    i++;
}

System.out.println(summe); // Ausgabe: 5050

```

**Aufgabe 9:**  
```java
for (int i = 1; i <= 20; i++) {
    if (i % 2 != 0) {
        System.out.println(i);
    }
}
```

---

## 5. Arrays

**Aufgabe 10:**  
```java
int[] zahlen = {1, 2, 3, 4, 5};

for (int i = 0; i < zahlen.length; i++) {
    System.out.println(zahlen[i]);
}
```

**Aufgabe 11:**  
```java
int[] zahlen = {1, 2, 3, 4, 5};
int summe = 0;

for (int zahl : zahlen) {
    summe += zahl;
}

System.out.println(summe); // Ausgabe: 15

```

**Aufgabe 12:**  
```java
public static int maxArray(int[] arr) {
    int max = arr[0];
    for (int zahl : arr) {
        if (zahl > max) {
            max = zahl;
        }
    }
    return max;
}

public static void main(String[] args) {
    int[] zahlen = {3, 7, 2, 9, 5};
    System.out.println(maxArray(zahlen)); // Ausgabe: 9
}

```

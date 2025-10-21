# Arbeitsblatt – Objektorientierung in Java (LÖSUNG)

## Teil A – Multiple Choice

1. Welche Aussage über Konstruktoren ist korrekt?
   - [ ] Konstruktoren haben immer einen Rückgabewert vom Typ `void`.
   - [x] Ein Konstruktor kann überladen werden.
   - [x] Wird kein Konstruktor definiert, erstellt der Compiler automatisch einen Standardkonstruktor.
   - [ ] Konstruktoren werden mit `return` beendet.

**Erklärung:** Konstruktoren haben keinen Rückgabewert (nicht mal void). Sie können überladen werden und der Compiler erstellt automatisch einen parameterlosen Default-Konstruktor, falls keiner definiert ist.

---

2. Welche Access Modifier in Java kennst du?
   - [x] `public`
   - [x] `default` 
   - [x] `protected`
   - [x] `private`

---

3. Welche Aussagen über das `this`-Schlüsselwort sind korrekt?
   - [x] `this` verweist auf das aktuelle Objekt.
   - [x] `this()` kann verwendet werden, um einen anderen Konstruktor derselben Klasse aufzurufen.
   - [x] `this` kann nur in Instanzmethoden verwendet werden, nicht in statischen Methoden.
   - [x] `this` dient zur Unterscheidung zwischen Attributen und gleichnamigen Parametern.

**Erklärung:** Alle Aussagen sind korrekt. `this` referenziert das aktuelle Objekts und kann nicht in statischen Methoden verwendet werden.

---

4. Welche Beziehung beschreibt **Komposition** in UML?
   - [ ] Temporäre Nutzung einer Klasse durch eine andere.
   - [x] Ein starkes „Ganze-Teil"-Verhältnis (schwarzer Diamant).
   - [ ] Eine „ist-ein"-Beziehung.
   - [ ] Eine schwache „Ganze-Teil"-Beziehung (weißer Diamant).

**Erklärung:** Komposition ist eine starke Aggregation mit schwarzem Diamant, bei der die Teile nicht ohne das Ganze existieren können.

---

## Teil B – Kurzantworten

5. **Erklären Sie den Begriff Encapsulation (Kapselung) in der objektorientierten Programmierung.**

Kapselung bedeutet, dass die interne Implementierung einer Klasse vor der Außenwelt verborgen wird. Attribute werden als `private` deklariert und der Zugriff erfolgt kontrolliert über `public` Getter- und Setter-Methoden. Dies schützt vor ungewollten Änderungen und ermöglicht Datenvalidierung.

---

7. **Worin unterscheiden sich Konstruktoren und gewöhnliche Methoden in Java?**

Konstruktoren haben den gleichen Namen wie die Klasse und keinen Rückgabewert. Sie werden automatisch beim Erstellen eines Objekts mit `new` aufgerufen und dienen der Initialisierung. Gewöhnliche Methoden haben einen beliebigen Namen, einen Rückgabewert (oder `void`) und werden explizit aufgerufen.

---

8. **Welchen Zweck erfüllen Getter- und Setter-Methoden?**

Getter-Methoden ermöglichen den kontrollierten Lesezugriff auf private Attribute. Setter-Methoden ermöglichen das kontrollierte Setzen von Attributwerten, oft mit Validierung. Sie wahren das Prinzip der Kapselung und bieten eine saubere Schnittstelle zur Klasse.

---

## Teil C – Code verstehen und korrigieren

9. **Folgender Code wirft einen Fehler. Erklären Sie, warum, und korrigieren Sie ihn.**

**Fehler:** Die Methode `Shirt` hat einen Rückgabewert `void`, ist also kein Konstruktor. Konstruktoren dürfen keinen Rückgabewert haben.

**Korrektur:**
```java
public class Shirt {
    private String brand;

    public Shirt(String brand) {  // void entfernt
        this.brand = brand;
    }
}
```

---

10. **Was gibt folgender Code aus? Begründen Sie Ihre Antwort.**

**Ausgabe:**
```
Name: Unbekannt
Name: Anna
```

**Begründung:** Der parameterlose Konstruktor ruft mit `this("Unbekannt")` den parametrisierten Konstruktor auf. `p1` erhält daher "Unbekannt" als Namen, `p2` erhält "Anna". Die `toString()`-Methode wird implizit beim `println()` aufgerufen.

---

## Teil D – UML

12. **UML-Klassendiagramm:**

```
+-------------------+
|      Library      |
+-------------------+
|                   |
+-------------------+
| + addBook(b:Book) |
+-------------------+
         ◇
         | 1
         |
         | 
         |0..*
+-------------------+
|       Book        |
+-------------------+
| - title: String   |
| - author: String  |
| - price: double   |
+-------------------+
|                   |
+-------------------+
```

**Erklärung:** Aggregation (weißer Diamant) da Books auch ohne Library existieren können.

---

13. **UML-Beziehungen:**

a) **Dependency (Abhängigkeit)** - gestrichelte Linie mit Pfeil  
b) **Aggregation** - weiße Raute, da Player ohne Team existieren können  
c) **Komposition** - schwarze Raute, da Classrooms ohne School nicht existieren können

---
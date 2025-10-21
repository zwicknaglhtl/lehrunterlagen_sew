# Arbeitsblatt – Objektorientierung in Java

**Name: ____________________**  

## Teil A – Multiple Choice

Kreuzen Sie die richtige(n) Antwort(en) an. Es können mehrere Antworten korrekt sein.

1. Welche Aussage über Konstruktoren ist korrekt?
   - [ ] Konstruktoren haben immer einen Rückgabewert vom Typ `void`.
   - [ ] Ein Konstruktor kann überladen werden.
   - [ ] Wird kein Konstruktor definiert, erstellt der Compiler automatisch einen Standardkonstruktor.
   - [ ] Konstruktoren werden mit `return` beendet.

---

2. Welche Access Modifier in Java kennst du?
   - [ ] `public`
   - [ ] `default`
   - [ ] `protected`
   - [ ] `private`

---

3. Welche Aussagen über das `this`-Schlüsselwort sind korrekt?
   - [ ] `this` verweist auf das aktuelle Objekt.
   - [ ] `this()` kann verwendet werden, um einen anderen Konstruktor derselben Klasse aufzurufen.
   - [ ] `this` kann nur in Instanzmethoden verwendet werden, nicht in statischen Methoden.
   - [ ] `this` dient zur Unterscheidung zwischen Attributen und gleichnamigen Parametern.

---

4. Welche Beziehung beschreibt **Komposition** in UML?
   - [ ] Temporäre Nutzung einer Klasse durch eine andere.
   - [ ] Ein starkes „Ganze-Teil“-Verhältnis (schwarzer Diamant).
   - [ ] Eine „ist-ein“-Beziehung.
   - [ ] Eine schwache „Ganze-Teil“-Beziehung (weißer Diamant).

---

## Teil B – Kurzantworten (je 2–3 Sätze)

5. Erklären Sie den Begriff **Encapsulation (Kapselung)** in der objektorientierten Programmierung.  
\
\
---


7. Worin unterscheiden sich Konstruktoren und gewöhnliche Methoden in Java?  
\
\
---

8. Welchen Zweck erfüllen Getter- und Setter-Methoden?  
\
\
---

## Teil C – Code verstehen und korrigieren

9. Folgender Code wirft einen Fehler. Erklären Sie, warum, und korrigieren Sie ihn.

```java
public class Shirt {
    private String brand;

    public void Shirt(String brand) {
        this.brand = brand;
    }
}
```

---

10. Was gibt folgender Code aus? Begründen Sie Ihre Antwort.

```java
public class Person {
    private String name;

    public Person() {
        this("Unbekannt");
    }

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + this.name;
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Anna");
        System.out.println(p1);
        System.out.println(p2);
    }
}
```
## Teil D – UML (3 Punkte pro Aufgabe)

12. Zeichnen Sie ein UML-Klassendiagramm für folgende Beschreibung:

- Klasse `Book` mit Attributen `title: String`, `author: String`, `price: double`.
- Klasse `Library`, die viele `Book`-Objekte enthält (Aggregation).
- `Library` hat eine Methode `addBook(Book b): void`.

13. Welche UML-Beziehungen passen zu den folgenden Szenarien und wie werden sie dargestellt?  

a) Eine Klasse `Shirt` **nutzt** temporär eine Klasse `Fabric` in einer Methode. 
b) Eine Klasse `Team` besteht aus mehreren `Player`-Objekten, die auch ohne das Team existieren können.
c) Eine Klasse `School` besteht aus mehreren `Classroom`-Objekten, die ohne die Schule nicht existieren können.


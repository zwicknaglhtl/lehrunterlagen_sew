\tableofcontents

# Interfaces

Seit Java 8 können Interfaces auch Code beinhalten.

## static-Methoden

Es könnten statische Methoden in einem Interface implementiert werden.

Beispiel:

```Java
    public interface Comparator<T> {
        int compare(T o1, T o2);
        …

        public static <T> Comparator<T> nullsFirst(Comparator<​? super T> comparator) {
            return new Comparators.NullComparator<>(true, comparator);
        }
        …
    }
```

## default-Methoden

Default-Methoden sind im Interface bereits implementiert. Sie können von den Klassen, die das Interface implementieren, überschrieben werden - müssen es aber nicht. Damit können Interfaces erweitert werden, ohne dass alle Klassen, die das Interface bereits implementieren, angepasst werden müssen.

Beispiel:

```Java
    public interface Comparator<T> {
        int compare(T o1, T o2);            // abstrakte Methode (klassisch)
        …

        default Comparator<T> reversed() {  // Methode mit einem Default-Verhalten (neu)
            return Collections.reverseOrder(this);
        }

        …
    }
```

Beispiel für die Verwendung:

```Java
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList((
                "Im Anfang (ἀρχή) war das Wort (λόγος) " +
                "und das Wort war bei Gott, " +
                "und das Wort war Gott." +
                "Im Anfang war es bei Gott. " +
                "Alles ist durch das Wort geworden " +
                "und ohne das Wort wurde nichts, was geworden ist. "
        ).split("[^A-Za-z]+")));

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareToIgnoreCase(b);
            }
        });

        // Ausgabe: Sortiert: [Alles, Anfang, Anfang, bei, bei, das, das, das, das, …
        System.out.println("sortiert: " + list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareToIgnoreCase(b);
            }
        }.reversed());  

        // Ausgabe: Reverse sortiert: [wurde, Wort, Wort, Wort, Wort, Wort, was, war, …
        System.out.println("reverse sortiert: " + list);
    }
}
```

## Functional-Interfaces

Interfaces mit einer **einzigen** abstrakten Methode, nennt man "Functional-Interfaces".
Diese können für Lambda-Ausdrücke eingesetzt werden.

Das Interface `Comparator` ist z.B. ein solches Functional-Interface.

```Java
    @FunctionalInterface
    public interface Comparator<T> {
    …
    int compare(T o1, T o2);
    …
    }
```

## Diverse Functional-Interfaces aus `java.util.function`

Seit Java8 findet man viele vordefinierte Functional-Interfaces für Lambda-Ausdrücke in
[`java.util.function`](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html):

* ***`Predicate`*** \newline
Überprüft eine Bedingung und liefert `true` oder `false`.

* ***`Function`***, ***`BiFunction`*** \newline
Berechnet einen Wert aus ein oder zwei Argumenten.

* ***`UnaryOperator`***, ***`BinaryOperator`***\newline
Erzeugt aus einem Objekt (bzw. zwei Objekten) ein neues Objekt vom selben Typ.

* ***`Supplier`***\newline
Liefert einen Wert und hat keine Argumente.

* ***`Consumer`***\newline
Verarbeitet ein Argument und hat keinen Rückgabewert

Genaueres erfahren wir nach dem Kapitel über Lambda Ausdrücke.

# Lambda Ausdrücke

## Anonyme Klassen

Viele Methoden, wie z.B. [`sort(...)`](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#sort-java.util.Comparator-), erwarten ein Objekt, das ein bestimmtes Interface (in diesem Fall [`Comparator`](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html))implementiert.

Da die Implementierung des Interfaces nur für diese eine Methode benötigt wird, haben wir es über eine anonyme Klasse implementiert.

```Java
    List<Integer> numbers = new ArrayList<>(Arrays.asList(11, 3, 42, 0, 89));

    numbers.sort(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a-b;
        }
    });
```

Das war dennoch ziemlich viel Schreibaufwand!

## Lambda-Ausdrücke

Besitzt das benötigte Interface nur eine einzige abstrakte Methode, können wir statt der anonymen Klasse einen Lambda-Ausdruck verwenden.

Da für den Compiler klar ist, welche Methode implementiert wird (es gibt ja nur eine), kann vieles weggelassen werden.

Beispiel: Der Methode `sort()` wird ein Lambda-Ausdruck übergeben, der die Methode `compare()` implementiert:

```Java
        List<Integer> numbers = new ArrayList<>(Arrays.asList(11, 3, 42, 0, 89));
        numbers.sort((Integer a, Integer b) -> { return Integer.compare(a, b); });
```

## Weitere Vereinfachungen der Lambda-Ausdrücke

* Parametertypen können meist entfallen
    (Typangaben entweder bei allen Parametern, oder bei keinem)

    ```Java
    // statt:
    Arrays.sort(zahlen, (Integer a, Integer b) -> { return Integer.compare(a, b); });
    // kürzer:
    Arrays.sort(zahlen, (a, b) -> { return Integer.compare(a, b); });
    ```

* Bei nur einer Anweisung können die geschwungenen Klammern und das `return` weggelassen werden

    ```Java
    Arrays.sort(zahlen, (a, b) -> Integer.compare(a, b));
    ```

* Bei genau einem Parameter können die runden Klammern weggelassen werden
    (dann ist aber keine Typangabe möglich)

    ```Java
    //statt:
    Predicate<Integer> istGerade = (Integer n) -> (n%2 == 0);
    // kürzer:
    Predicate<Integer> istGerade = n -> (n%2 == 0);
    ```

## Methodenreferenzen

Wenn im Lambda-Ausdruck nur eine statische Methode aufgerufen werden soll, kann diese Methode über eine Methodenreferenz angegeben werden.

Beispiel:

```Java
  List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 1, 9, 8));
  // statt:
  list.forEach(n -> System.out.println(n));
  // noch kürzer:
  list.forEach(System.out::println);
```

Anmerkung:

Es gibt (ab Java 9): `List.of(...)`{.java}

## Konstruktorenreferenzen

Funktionieren wie Methodenreferenzen.

Beispiele^[Keine Panik, die Streams werden später noch erklärt.
In dem Beispiel geht es nur um die Lambda-Ausdrücke]:

```Java
  // statt:
  Stream.of("15 9 11 16".split(" ")).map(s -> new Integer(s)) …
  // noch kürzer:
  Stream.of("15 9 11 16".split(" ")).map(Integer::new) …

  // das geht auch für Array-Konstruktoren, statt:
  Stream.of("15 9 11 16".split(" ")).toArray(len -> new Integer[len]) …
  // noch kürzer:
  Stream.of("15 9 11 16".split(" ")).toArray(Integer[]::new) …
```

## Zugriff auf Variablen in Lambda Ausdrücke

<!-- TODO Begriff Closure erklären -->

* Auf lokale Variablen der umgebenden Methode kann nur zugegriffen werden,
    wenn diese final^[oder auto-final, d.h. sie werden nach der Initialisierung
    in der ganzen Methode nur gelesen] sind.

    * Trick: Falls man doch einmal eine lokale Variable der Methode ändern muss,
        verwende ein Array. \newline
        (Die Elemente eines Arrays sind niemals final.)

    * Die Variablen in Lambda-Ausdrücken müssen anders heißen, als die lokalen Variablen.

* Auf Attribute (Instanzvariablen) statische Variablen und Konstanten der Klasse
    kann ganz normal zugegriffen werden.

    * Die Variablen dürfen auch gleich heißen, verdecken aber dann den Zugriff Aufgaben
        die Attribute, etc.

* **Achtung:** In einem Lambda-Ausdruck ist das `this`-Objekt, das Objekt der umschließenden Klasse. Bei einer anonymen inneren Klasse ist das anders!

# Beispiele zu den Interfaces aus `java.util.function`
(siehe auch: <http://www.java2s.com/Tutorials/Java/java.util.function/BiConsumer/>)

* ***`Predicate`***

```Java
    Predicate<String> isShortText  = s -> s.length() <= 5;
    System.out.println(isShortText.test("htl3r"));   // Ausgabe: true
```

* ***`Function`***

```Java
    Function<String, String> noDigits = s -> s.replaceAll("\\d", "#");
    System.out.println(noDigits.apply("0815-Text")); // Ausgabe: ####-Text
```

* ***`BiFunction`***

```Java
    BiFunction<String, Integer, String> repeat = (s, n) -> {
        StringBuilder b = new StringBuilder();
        while (n-- > 0) {
            b.append(s);
        }
        return b.toString();
    };

    System.out.println(repeat.apply("-HTL3R-", 5));  // -HTL3R--HTL3R--HTL3R--HTL3R--HTL3R-
```

* ***`UnaryOperator`***

```Java
    System.out.println("\nExample UnaryOperator");
    UnaryOperator<String> threeTimes = s-> s+s+s;
    System.out.println(threeTimes.apply("HTL3R "));  // Ausgabe: "HTL3R HTL3R HTL3R "
```

* ***`BinaryOperator`***

```Java
    BinaryOperator<Integer> pow = (basis, exponent) -> (int)Math.pow(basis, exponent);
    System.out.println(pow.apply(2, 4));             // Ausgabe: 16
```

* ***`Supplier`***

```Java
    Supplier<String> mySchool = () -> "HTL3R";
    System.out.println(mySchool.get());              Ausgabe: HTL3R
```

* ***`Consumer`***

```Java
    Consumer<String> printToLowerCase = s -> System.out.println(s.toLowerCase());
    printToLowerCase.accept("Franz Breunig");        Ausgabe: franz breunig
```

# Optionals

* Die Optionals sind Behälter, die Werte speichern können, sowie auch wissen, wenn ein Wert fehlt.

* Es gibt Optionals für:

    * ***Objekte***: `Optional<T>`

    * und den drei primitiven Datentypen ***`int`***, ***`long`***, ***`double`***:
        `OptionalInt`, `OptionalLong` und `OptionalDouble` \newline
        (Für die anderen primitiven Datentypen gibt es keine Optionale.)

* ***Erzeugt*** können sie werden mit den statischen Befehlen:
    * ***`empty()`*** (erzeugt ein "*leeres*" Element)
    * ***`of(value)`*** (wirft bei null eine NullPointerException, wenn `value` `null` ist)
    * ***`ofNullable(value)`*** (gibts nur bei `Optional<T>` und kann auch `null`-Elemente erzeugen)

* ***Ausgelesen*** kan der gespeicherte Wert mit den Methoden:
    * ***`get()`*** (liefert den Wert, falls er `null` ist, wird eine `NoSuchElementException` geworfen)
    * ***`orElse(alternativeValue)`*** (liefert den Wert, falls er `null` ist,
        wird `alternativeValue` geliefert, ohne eine Exception auszulösen)

* ***`isPresent()`*** ist `true`, wenn ein Wert (und nicht `null`) gespeichert ist.

* ***`equals(other)`***, ***`hashcode()`*** sowie ***`toString()`*** lösen keine
    Exception bei fehlenden Werten aus und arbeiten immer mit den eingebetteten Werten

* Es gibt auch noch viele andere Befehle, auf die wir hier nicht eingehen:\newline
    `filter(…)`, `ifPresent(…)`, `orElseGet(…)`, `orElseThrow(…)`, `map(…)` und `flatMap(…)`

* ***Beispiel für `OptionalInt`:***

    ```Java
    OptionalInt a = OptionalInt.empty(); // a bekommt keinen Wert
    OptionalInt b = OptionalInt.of(10);

    System.out.printf("a.isPresent: %-5s, a = %s\n", a.isPresent(), a);
    System.out.printf("b.isPresent: %-5s, b = %s\n", b.isPresent(), b);

    System.out.printf("a + b = %d\n", a.orElse(0) + b.orElse(0));

    // Ausgabe:
    // a.isPresent: false, a = OptionalInt.empty
    // b.isPresent: true , b = OptionalInt[10]
    // a + b = 10
    ```

# Streams

Streams vereinfachen vor allem das Arbeiten mit Collections und Arrays. Anstatt mit Hilfe
von Schleifen und Bedingungen den Lösungs-Algorithmus^[
Arten der Programmierung:\newline
***imperative Programmierung***: Beschreibung des Lösungsweges (Algorithmus)
    = klassischer Weg in Java, C, C++, JavaScript, etc.\newline
***deklarative Programmierung***: Beschreibung des Problems (der Lösung),
    der Lösungsweg wird automatisch ermittelt
    = in Java Streams, sonst: Haskell, Lisp, Prolog und im weitesten Sinne auch SQL
]
zu beschreiben, können wir mit Streams arbeiten.

<!-- TODO besser beschreiben was Streams überhaupt sind, siehe Codebeispiel -->
Streams besitzen eine Datenquelle (z.B. eine Collection oder ein Array) und eine oder mehrere Verarbeitungsschritte (z.B. Filtern, Sortieren, etc.).

***Beispiel***: Ermittle wie viele Zahlen im Array `a` kleiner als `10` sind:

```Java
    int[] a = {1, 2, 5, 12, 9, 11, 6, 88};

    // klassisch:
    int counter = 0;
    for (int n: a) {
        if (n < 10) {
            counter++;
        }
    }
    System.out.printf("%d kleine Elemente\n", counter);     // Ausgabe: 5 kleine Elemente

    // kürzer mit Streams (filtere alle Elemente < 10 und zähle sie)
    System.out.printf("%d kleine Elemente\n",
            Arrays.stream(a).filter(n -> n < 10).count()); // Ausgabe: 5 kleine Elemente

```

<!--
Leider vermitteln mir die Streams das Gefühl, dass sie noch etwas unvollständig sind.
Aber wir können ja auf Java9, 10, ... hoffen. Nichts desto trotz ist das Thema Streams
so umfangreich, dass wir es hier nicht komplett behandeln werden können.
-->

## Arbeitsschritte mit Streams

1) ***create:*** Erzeugen des Streams.
2) ***intermediate operation***: Beliebig viele Operationen auf dem Stream.
3) ***terminal operation***: Die Endoperation löst erst die Verarbeitung des Streams aus.

***Beispiel***: Ermittle die Summe der drei größten durch Drei
    und durch Sieben teilbaren Zahlen der Liste `numbers`:

```Java
    // durch 3 und durch 7 teilbaren Zahlen sind: 21 (2x), 63 (3x), 147 (1x), 189 (1x),
    // die Summe der drei größten Zahlen davon ist: 189 + 147 + 63 = 399
    List<Integer> numbers = Arrays.asList(63, 63, 21, 21, 3, 7, 189, 14, 63, 147, 6, 99);

    int sum =
        numbers
        // create: Erzeugen des Streams aus der Liste
        .stream()                  
        // intermediate operation: filtert die Elemente              
        .filter(n -> n % 3 == 0 && n % 7 == 0) 
        // intermediate operation: sortiert verkehrt  
        .sorted((a,b) -> Integer.compare(b,a)) 
        // intermediate operation: reduziert auf drei Elemente  
        .limit(3)                     
        // terminale operation: summiert die drei Elemente           
        .collect(summingInt(Integer::intValue)); 

    System.out.printf("Die Summe der drei größten durch Drei und"
                      + " durch Sieben teilbaren Zahlen ist: %d\n", sum);
```

Unterscheide zwischen [Streams](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) für Objekte und [IntStream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html), [LongStream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/LongStream.html), [DoubleStream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/DoubleStream.html) für die primitiven Typen int, long und double. Je nach Stream unterscheiden sich die verfügbaren Methoden.

## `create`: Streams erzeugen

* ***`Collection`***
  * ***`stream()`***: Erzeugt aus einer `List` oder einem `Set` einen `Stream`

    Beispiel:

    ```Java
        Stream<String> x = new TreeSet<>(Arrays.asList("a", "b", "a")).stream();
    ```

* ***`Arrays`***
  * ***`stream(array)`***: Erzeugt aus einem Array einen `Stream`, `IntStream`, `LongStream` oder `DoubleStream`

    Beispiel:

    ```Java
        int[] b = {3,7,9};
        IntStream bi = Arrays.stream(b);
    ```

  * ***`stream(array, startInclusive, endExclusive)`***: Erzeugt aus einem Array einem `Stream`, `IntStream`, `LongStream` oder `DoubleStream` von dem Index `startInclusive` bis ohne den Index `endExclusive`

    Beispiel:

    ```Java
        String[] c = "Evi Franz Agi Thesi Uli".split(" ");
        // liefert "Agi", "Thesi"
        Stream<String> cs = Arrays.stream(c, 2, 4);
    ```

* ***`Stream`***: Statische Methoden in `Stream`, `IntStream`, `LongStream` und `DoubleStream`:
  * ***`empty()`***: Liefert einen leeren Stream

    Beispiel:
  
    ```Java
        Stream<String> s = Stream.empty();
    ```

  * ***`of(Elements)`***: Erzeugt aus den angegebenen Elementen einen Stream

      Beispiele:

      ```Java
        Stream<String> s = Stream.of("a", "b", "c");
        IntStream      i = IntStream.of(1, 2, 3);
      ```

  * ***`generate(...)`***: Erzeugt (unendlich viele) Elemente mit Hilfe eines `Supplier`s

    Beispiel: Ein Stream mit int-Zufallszahlen aus dem Intervall
    [`Integer.MIN_VALUE`, `Integer.MAX_VALUE`]:

    ```Java
        IntStream r = IntStream.generate(new Random()::nextInt);
    ```

  * ***`iterate(...)`***: Erzeugt nach einem Bildungsgesetz einen Stream

    Beispiel: Erzeugt den Stream: `a, a*a, a*a*a, a*a*a*a, a*a*a*a*a, a*a*a*a*a*a,` ...:

    ```Java
        Stream<String> w = Stream.iterate("a", e -> e + "*a");
    ```

* ***`String`*** erzeugt aus allen Zeichen des Strings einen int-Stream mit den UTF-8-Werten.

    Beispiel:

    ```Java
        IntStream chars = "Wappler".chars();
    ```

* ***`Files`***

  `Files` kennt drei statische Methoden fürs Dateisystem:

  * ***`list(directory)`***: Liefert alle Elemente des Verzeichnisses `directory`

    Beispiel:

    ```Java
            Stream<Path> content = Files.list(Paths.get("resources"));
    ```

  * ***`walk(directory[, maxDepth][, fileVisitOptions])`***: Liefert alle Elemente aus dem Verzeichnis `directory` und aus allen Unterverzeichnissen (inkl. aller Unterverzeichnissen). `maxDepth` ist optional und gibt die maximale Verzeichnis-Tiefe an `fileVisitOptions` ist optional und kann derzeit ausschliesslich `fileVisitOptions.FOLLOW_LINKS` sein (folge symbolischen Links).

    Beispiel:

    ```Java
            Stream<Path> content = Files.walk(Paths.get("../"));
    ```

  * ***`find(directory, maxDepth, matcher[, fileVistiOptions] )`***: Liefert alle Elemente des Verzeichnisses

    Beispiel:

    ```Java
            Stream<Path> files = Files.find(Paths.get(".."),
                5, // gehe max. 5 Subordner in die Tiefe
                (path, attr) -> String.valueOf(path).endsWith(".java"));
    ```

  `Files` kennt eine statische Methode zum Lesen von Textdateien:

  * ***`lines(file)`***: Zum zeilenweise Lesen aus Textdateien

    Beispiel:

    ```Java
            Stream<String> lines = Files.lines(Paths.get("resources/test.txt"),
                                Charset.forName("UTF-8"));
    ```

* ***`Random`***: Generiert Zufallszahlen-Streams, es exisitieren Methoden
für Int/Long/DoubleStreams

    * ***`ints()`***: Erzeugt einen unendlichen IntStream von Zufallszahlen
    aus dem Intervall [`Integer.MAX_VALUE`, `Integer.MIN_VALUE`] \newline
    Beispiel:
    ```Java
        IntStream r = new Random().ints();
    ```

    * ***`longs()`***: Erzeugt einen unendlichen LongStream von Zufallszahlen
    aus dem Intervall [`Long.MAX_VALUE`, `Long.MIN_VALUE`]

    * ***`doubles()`***: Erzeugt einen unendlichen LongStream von Zufallszahlen
    aus dem Intervall [`0`, `1`[ (1 ist nicht mehr dabei)

    * ***`ints(streamSize)`, `longs(streamSize)`, `doubles(streamSize)`***:
    Erzeugt einen Int/Long/DoubleStream von Zufallszahlen mit `streamSize` Elementen,
    das Intervall ist wie bei `ints()`, `longs()`, `doubles()`

    * ***`ints(first, last)`, `longs(first, last)`, `doubles(first, last)`***:
    Erzeugt einen unendlichen Int/Long/DoubleStream von Zufallszahlen
    im Intervall [`first`, `last`[ (inklusive `first`, exklusive `last`) \newline
    Beispiel:
    ```Java
        IntStream r = new Random().ints(0, 2); // z.B.: 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0,
    ```

     * ***`ints(streamSize, first, last)`, `longs(streamSize, first, last)`,
    `doubles(streamSize, first, last)`***:
    Erzeugt einen Int/Long/DoubleStream von Zufallszahlen mit
    `streamSize` Elementen
    im Intervall [`first`, `last`[ (inklusive `first`, exklusive `last`) \newline
    Beispiel:
    ```Java
        IntStream r = new Random().ints(5, 0, 2); // z.B.: 0, 0, 1, 0, 1
    ```

* Es gibt auch noch zahllose andere Möglichkeiten, Streams zu erzeugen, siehe:

    * [https://docs.oracle.com/javase/8/docs/api/java/util/stream/class-use/Stream.html](https://docs.oracle.com/javase/8/docs/api/java/util/stream/class-use/Stream.html)


## Intermediäre Operationen: Streams bearbeiten

Alle intermediären Operationen liefern wieder einen neuen Stream. Damit können beliebig viele
intermediäre Operationen einfach aneinander gehängt werden (= fluent Notation).

* ***Filtern***:
    * ***`filter(predicate)`***: Filtert den Stream mit Hilfe des `predicate`s\newline
    Beispiel:
    ```Java
    int[] a = {1, 2, 5, 12, 9, 11, 6, 88};
    IntStream littleNumbers = Arrays.stream(a).filter(n ->  n < 10);
    ```

    * ***`distinct()`***: Entfernt doppelte Elemente aus dem Stream, ohne ihn umzuordnen \newline
    Beispiel:
    ```Java
    int[] a = {1, 2, 5, 12, 2, 1, 88, 9, 11, 6, 88};
    IntStream n = Arrays.stream(a).distinct(); // = [1, 2, 5, 12, 88, 9, 11, 6]
    ```

    * ***`limit(newLen)`***: Kürzt den Stream auf die Länge `newLen` \newline
    Beispiel:
    ```Java
    IntStream a = "0123456789".chars().limit(5); // = [48, 49, 50, 51, 52]
    ```

    * ***`skip(n)`***: Überspringt die ersten `n` Elemente des Strings \f
    Beispiel:
    ```Java
    IntStream a = "0123456789".chars().skip(8); // = [56, 57]
    ```

* ***Sortieren***
    * ***`sorted()`***: Sortiert den String nach der "natürlichen" Ordnung der Elemente
    Beispiel:
    ```Java
    int[] b = {2, 1, 5, 12, 9, 11, 6, 88};
    IntStream a = Arrays.stream(b).sorted(); // = [1, 2, 5, 6, 9, 11, 12, 88]
    ```

    * ***`sorted(comparator)`*** sortiert mit Hilfe des Comparators
    (nur Stream, kein Int/Long/DoubleStream)
    Beispiel: Sortiere die Elemente ohne Berücksichtigung der Groß-/Kleinschreibung absteigend.
    ```Java
    Stream<String> a = Arrays.asList("Hallo", "Wappler", "wie", "geht", "es", "dir").stream()
    .sorted((x, y) -> y.compareToIgnoreCase(x)); // = [wie, Wappler, Hallo, geht, es, dir]
    ```


* ***Transformieren***
    * ***`map(mapper)`***: Erzeugt aus einem Stream einen neuen Objekt-Stream
    
     Beispiel: Wandelt einen `IntStream` in einen `Stream<String>` mit den vierstelligen hexadezimalen Werten der Zahlen um:
    
    ```Java
    Stream<String> a = Stream.of(55, 255, 512, 768)
    .map(n -> String.format("0x%04X", n)); // = [0x0037, 0x00FF, 0x0200, 0x0300]
    ```

    * ***`mapToInt(mapper)`***, ***`mapToLong(mapper)`***, ***`mapToDouble(mapper)`***:
    aus einem Stream über Ojekte kann ein
    `Int`/`Long`/`DoubleStream` erzeugt werden \newline
    Beispiel: Erzeugt aus einem String-Stream einen Stream mit den Längen der Strings:
    ```Java
    Stream<String> s = Stream.of("eins", "zwei", "drei", "sechsundzwanzig")
    .mapToInt(s -> s.length());
    ```

    * ***`boxed()`***: Macht aus einem Int/Long/DoubleStream einen Objekt-Stream.

    * ***`concat(a, b)`***: Verbindet die beiden Streams `a` und `b` zu einem einzigen
    \newline
    Beispiel:
    ```Java
    IntStream a = IntStream.of(1, 2, 3, 4);
    IntStream b = IntStream.of(10, 11);
    IntStream both = IntStream.concat(a, b);
    ```


* ***Maps flach machen***
    * ***`flatMap(mapper)`***: 
    
    Mittels `map(mapper)` kann jedes Objekt in genau ein anderes Objekt umgewandelt werden. `flatMap(mapper)` hingegen wandelt jedes Element in einen Stream von Elementen um. Damit kann jedes Element in beliebig viele andere Objekte, oder auch in überhaupt keines, umgewandelt werden.
    
    Dies nützt man vor allem um  aus einem Stream mit eingebetteten Datenstrukturen
    einen neuen Stream, in dem alle Elemente der eingebetteten Datenstrukturen
    direkt liegen umzuwandeln.\newline
    
    Beispiel:

    ```Java
    // s = [[a1,a2], [b1,b2,b3,b4,b5], [c1]]
    Stream<List<String>> s = Stream.of(
        Arrays.asList("a1", "a2"),
        Arrays.asList("b1", "b2", "b3", "b4", "b5"),
        Arrays.asList("c1")
    );
    Stream<String> sFlat = s.flatMap(Collection::stream);
    System.out.println(Arrays.toString(sFlat.toArray())); // [a1, a2, b1, b2, b3, b4, b5, c1]
    ```

    * ***`flatMapToInt(mappper)`, `flatMapToLong(mappper)`, `flatMapToDouble(mappper)`***:
    macht aus den Elementen der eingebetteten Datenstrukturen direkt
    einen Int/Long/DoubleStream \newline
    Beispiel:
    ```Java
    // s = [[11,12], [21,22,23,24,25], [31]]
    Stream<List<Integer>> s = Stream.of(
        Arrays.asList(11, 12),
        Arrays.asList(21, 22, 23, 24, 25),
        Arrays.asList(31)
    );
    IntStream sFlat = s.flatMapToInt(list -> list.stream().mapToInt(n -> n));
    System.out.println(Arrays.toString(sFlat.toArray())); // [11, 12, 21, 22, 23, 24, 25, 31]
    ```

* ***Abhören***
    * ***`peek(consumer)`***: Damit kann jedes Element betrachtet werden\newline
    Beispiel:
    ```Java
    Stream<String> a = Arrays.asList("Hallo", "Wappler", "wie", "geht", "es", "dir").stream()
    .peek(System.out::println);
    ```


## Terminale Operationen
Beenden die intermediäre Pipeline. Der Stream kann nachher nicht mehr verwendet werden!

* ***Findet das erste Element***
    * ***`findFirst()`***: Liefert das erste Element des Streams eingepackt
    in ein Optional \newline
    Beispiel:
    ```Java
    Stream<String> a = Arrays.asList("wie", "geht", "es", "dir").stream();
    System.out.println(a.sorted().findFirst().get()); // Ausgabe: dir
    ```
    Bemerkung: Für parallele Streams verwende besser `findAny()`, wenn
    du einfach nur irgend ein Element haben möchtest.

* ***prüft Bedingungen***
    * ***`anyMatch(matcher)`***: Bestimmt, ob mindestens ein Element matcht\newline
    Beispiel: Gibt es zumindest ein Element, das mehr als 5 Zeichen hat:
    ```Java
    Stream<String> a = Arrays.asList("Hallo", "Wappler", "wie", "geht", "es", "dir").stream();
    System.out.println(a.anyMatch(s -> s.length() > 5)); // Ausgabe: true
    ```

    * ***`allMatch(matcher)`***: Bestimmt, ob alle Elemente des Streams matchen\newline
    Beispiel: Haben alle Elemente des mehr als 5 Zeichen:
    ```Java
    Stream<String> a = Arrays.asList("Hallo", "Wappler", "wie", "geht", "es", "dir").stream();
    System.out.println(a.allMatch(s -> s.length() > 5)); // Ausgabe: false
    ```

    * ***`noneMatch(matcher)`***: Bestimmt, ob kein einziges Element des Streams matcht \newline
    Beispiel: Gibt es kein einziges Element, das mehr als 5 Zeichen hat:
    ```Java
    Stream<String> a = Arrays.asList("Hallo", "Wappler", "wie", "geht", "es", "dir").stream();
    System.out.println(a.noneMatch(s -> s.length() > 5)); // Ausgabe: false, da Wappler zu lang ist
    ```

* ***Iterieren***
    * ***`forEach(consumer)`*** macht mit jedem Element etwas\newline
    Beispiel: Zeichnet einen Weihnachtsbaum, die halbe Anzahl der Sterne
    pro Zeile steht im Stream
    ```Java
       /* Ausgegeben wird:
             **
            ****
           ******
          ********
         **********
        ************
             **
             **
      */
      IntStream is = IntStream.of(1, 2, 3, 4, 5, 6, 1, 1);
      is.forEach(n -> System.out.println(
          "       ".substring(0, 6-n) + "*************".substring(0, 2*n)));
    ```
    Bemerkung: Für parallele Streams verwende besser `forEachOrdered()`, wenn
    du die Elemente in einer bestimmten Reihenfolge bearbeiten möchtest.

\needspace{5cm}
* ***`Einzelwerte ermitteln`***
    * ***`count()`***: Bestimmt die Anzahl der Elemente \newline
    Beispiel: Zählt wie viele Elemente im Array `a` kleiner als 10 sind:
    ```Java
    int[] a = {1, 2, 5, 12, 9, 11, 6, 88};
    System.out.printf("%d kleine Elemente\n",
        Arrays.stream(a).filter(n ->  n < 10).count()); // Ausgabe: 5 kleine Elemente
    ```

    * ***`min()`, `max()`***: Bestimmt das kleinste bzw. größte Element und gibt
    es in einem Optional eingebettet zurück
     \newline
    Beispiel:
    ```Java
    Stream<String> a = Arrays.asList("Hallo", "Wappler", "wie", "geht", "es", "dir").stream();
    System.out.println(a.max(String::compareToIgnoreCase)); // Ausgabe: Optional[wie]
    ```

    * ***`average()`, `sum()`***: Der Mittelwert bzw. die Summe kann nur
    für Int/Long/DoubleStreams bestimmt werden, die Methoden funktionieren
    genau so wie `min()` und `max()`

    * ***`reduce()`***: Reduziert die Elemente auf einen Wert. Das macht auch z.B. `min()`,`max()` oder `sum()`. Mit `reduce()` stellt uns Java eine allgemeine Funktion zu Verfügung. 
        \newline
        `reduce()` benötigt zwei Argumente:
        * den initialen Wert (bzw. das Default-Ergebnis, wenn sich keine Elemente im Stream befinden).
        * Die Akkumulator-Funktion, die das partielle Ergebnis der bisherigen Reduktion und das nächste Element im Stream erhält.
        \newline
        Beispiel:    
         ```Java
         int[] numbers = {1, 2, 5, 12};
         int summe = Arrays.stream(numbers).reduce(0, (a,b) -> a+b); // 20
         summe = Arrays.stream(numbers).sum(); //würde das gleiche Ergebnis liefern.
         ```

\needspace{5cm}
* in ein ***Array umwandeln***
    * ***`toArray()`*** wandelt den Stream in ein Array um \newline
    Beispiel:
    ```Java
    // Achtung: Das Array enthält zwar `String`-Objekte, kann aber nicht auf `String[]`
    // gecastet werden
    Stream<String> a = Arrays.asList("Hallo", "Wappler", "wie", "geht", "es", "dir").stream();
    Object[] as = a.toArray();
    // besser:
    String[] as2 = a.toArray(String[]::new);
    ```
    Beispiel: Zwanzig ganzzahlige Zufallszahlen aus dem Intervall [10, 19]:
    ```Java
    int[] r20 = new Random().ints(20, 10, 20).toArray();
    ```


\needspace{2 cm}
* ***`collect(…)`***: Sammelt Elemente des Streams ein
    * Verwende dazu Standardverfahren aus `Collectors`.
        * Siehe dazu die API und das untenstehende große Beispiel.

    * Man kann für collect auch einen eigenen Consumer schreiben, sie dazu dieses [Tutorial](https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html#collect)

Beispiele für `Collectors`: `joining`, `toList`, `summarizingInt`, `partitioningBy`,
`groupingBy`, `counting` (siehe Beilage):

```Java
    // Erzeugt aus dem Text eine Liste mit Worten.
    // Das "split" trennt an allen Zeichen, die keine (deutschen) Buchstaben sind.
    // Alle nun folgenden alle Stream-Beispiele arbeiten mit words.stream().
    // (Der Text ist der Einheitsübersetzung der Bibel entnommen.)
    List<String> words = Arrays.stream((
        "Im Anfang schuf Gott Himmel und Erde; die Erde aber war wüst und " +
        "wirr, Finsternis lag über der Urflut und Gottes Geist schwebte über dem " +
        ...
        "sehr gut. Es wurde Abend und es wurde Morgen: der sechste Tag."
    ).split("[\\P{Alpha}]+")).collect(Collectors.toList());

    // simple-joined mit Trennelement
    System.out.println("just joined: " + words.stream().collect(Collectors.joining(", ")));

    // complex-joined - als String-Array-Darstellung
    String complexJoined = words.stream()
            // Elemente zu einem String verketten
            .collect(Collectors.joining(
                    "\", \"",                // Trennelement:  ", "
                    "new String[] { \"",     // Prefix;        new String {"
                    "\" }"                   // Suffix:        "}
            ));
    System.out.printf("Worte als Array-Literal: %s%n%n", complexJoined);

    // toList
    List<String> wordList = words.stream().collect(Collectors.toList());
    System.out.printf("WortListe: %s%n%n", wordList);

    // Statistik
    IntSummaryStatistics stat = words.stream()
            .collect(Collectors.summarizingInt(w -> w.length()));
    System.out.println(stat);
    System.out.printf(
            "wrodlen statistic: min=%d, max=%d, mid=%f%n%n" ,
            stat.getMin(), stat.getMax(), stat.getAverage());

    // Partitionieren: shortWords haben maximal fünf Zeichen
    Map<Boolean, List<String>> shortWords = words.stream()
            .map(String::toLowerCase)
            .distinct()
            .sorted()
            .collect(Collectors.partitioningBy(w -> w.length() <= 5));
    System.out.printf("short words: %s%n",   shortWords.get(true));
    System.out.printf("long  words: %s%n%n", shortWords.get(false));

    // Gruppieren: Nach dem Anfangsbuchstaben
    Map<String, List<String>> firstLetter = words.stream()
            .map(String::toLowerCase)
            .distinct()
            .sorted()
            .collect(Collectors.groupingBy(word -> word.substring(0,1).toLowerCase()));
    System.out.printf("groupt by first Letter: %s%n%n", firstLetter);

    // Gruppieren:nach der Worthäufigkeit mit Supplier und Downstream-Collector
    Map<String, Long> wordFrequency = words.stream()
            .map(String::toLowerCase)
            .sorted()
            .collect(
                    Collectors.groupingBy(
                            word -> word,          // key der Map (= bei uns das Wort selbst)
                            TreeMap::new,          // mapFactory (= Map-Art zum Speichern)
                            Collectors.counting()  // value der Map (= Worthäufigkeit)
                    ));
    System.out.printf("Worthaeufigkeit: %s%n", wordFrequency);
```

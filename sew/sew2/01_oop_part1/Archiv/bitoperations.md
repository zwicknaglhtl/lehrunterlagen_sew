---
title:  'Bitoperationen'
---

- Datentypen int und long

    Ein ```int``` besteht in Java immer aus 32bit, ein ```long``` aus 64bit. Um negative und positve Zahlen einfach speichern zu können, werden die Zahlen als [Zweierkomplement](https://de.wikipedia.org/wiki/Zweierkomplement) kodiert. Das Bit an der höchsten Stelle (ganz link) ist dabei 1 wenn es sich um eine negative Zahl handelt.

    Schreibt man in meinem Programm ```1```{.java} bekomme ich ein ```int```-Literal, mit ```1L```{.java} ein ```long```-Literal.

- Erinnerung: Schreibweisen von Zahlen

    ```java
    int dec = 110;            // no prefix   --> decimal literal
    int bin = 0b1101110;      // '0b' prefix --> binary literal
    int oct = 0156;           // '0' prefix  --> octal literal
    int hex = 0x6E;           // '0x' prefix --> hexadecimal literal

    long maxLong = 0x7fff_ffff_ffff_ffffL; //Underscores können zur besseren Lesbarkeit eingefügt werden
    byte nybbles = 0b0010_0101;
    long bytes = 0b11010010_01101001_10010100_10010010;
    ```

- Umwandlung String -- int/long

    ```java
    int n1 = Integer.parseInt("10110111", 2); // = ...(Zahl, Basis)
    long n2 = Long.parseLong ("10110111", 2); // = ...(Zahl, Basis)
    String s1a = Integer.toString(n1, 2); // = ...(Zahl, Basis)
    String s2a = Long.toString (n2, 2); // = ...(Zahl, Basis)
    String s1b = Integer.toBinaryString(n1);
    String s1o = Integer.toOctalString (n1);
    String s1h = Integer.toHexString (n1);
    String s2b = Long.toBinaryString (n2);
    String s2o = Long.toOctalString (n2);
    String s2h = Long.toHexString (n2);
    ```

- Das Ergebnis einer Bitoperation ist immer int oder long, bei byte oder short muss gecastet werden.

  - Beispiel:

    ```java
    byte b = 0x1f;
    byte c = b >> 1; // Syntax-Error, da b >> 1 vom typ int ist
    byte d = (byte) (b >> 1);
    ```

- Bitoperationen

  Bei alle Beispielen ist (Die Punkte bei der Binärdarstellung dienen lediglich der besseren Lesbarkeit):

    ```java
    int a = 0xAF; // = 1010.1111
    int b = 0x3C; // = 0011.1100
    ```

  - Bitweises und: `&` → Beide Bits müssen 1 sein, damit das Ergebnis 1 ist.

    - Beispiel:

    ```java
    int c = a & b; // a =   1010.1111
                   // b =   0011.1100
                   // a&b = 0010.1100
    ```

  - Bitweises oder: `|` → Mindestens ein Bit muss 1 sein.

    - Beispiel:

    ```java
    int d = a | b; // a =   1010.1111
                   // b =   0011.1100
                   // a|b = 1011.1111
    ```

  - Bitweises exklusiv oder (XOR): `^` → Genau ein Bit darf 1 sein.

    - Beispiel:

    ```java
    int e = a ^ b; // a =   1010.1111
                   // b =   0011.1100
                   // a^b = 1001.0011
    ```

  - Bitweises invertieren: `~` → Jedes Bit wird umgedreht (0 -- 1)

    - Beispiel (beachte die führenden Nullen, da `int` 32 Bit hat):

    ```java
    int f = ~a; // a = 0000.0000.0000.0000.0000.0000.1010.1111
                // f = 1111.1111.1111.1111.1111.1111.0101.0000
    ```

- Shift-Operationen

  - nach Links schieben: `<<` → Schiebt die Bits um beliebig
        viele Stellen nach links

    - Beispiel:

    ```java
    int a = 0xff;
    int b = a << 4; // (4=Anzahl der Stellen) = 0xff0
    ```

  - nach Rechts schieben: `>>` → Schiebt die Bits um beliebig viele Stellen nach rechts (Dabei wird links immer das Vorzeichen (= das linkeste Bit) hereingeschoben.

    Beispiel:

    ```java
    int a = 0x88aa11dd; // = 1000.1000.1010.1010.0001.0001.1101.1101
    int b = a >> 4;     // = 1111.1000.1000.1010.1010.0001.0001.1101
                        // = 0xf88aa11d (4=Anzahl der Stellen)
    int c = 0x77aa11dd; // = 0111.0111.1010.1010.0001.0001.1101.1101
    int b = c >> 4;     // = 0000.0111.0111.1010.1010.0001.0001.1101
                        // = 0x077aa11d (4=Anzahl der Stellen)
    ```

  - nach Rechts schieben: `>>>` → Schiebt die Bits um beliebig
        viele Stellen nach rechts
        (Dabei wird links immer Null hereingeschoben.)

    Beispiel:

    ```java
    int a = 0x88aa11dd; // = 1000.1000.1010.1010.0001.0001.1101.1101
    int b = a >>>4;     // = 0000.1000.1000.1010.1010.0001.0001.1101
                        // = 0x088aa11d (4=Anzahl der Stellen)
    int c = 0x77aa11dd; // = 0111.0111.1010.1010.0001.0001.1101.1101
    int b = a >>> 4   ; // = 0000.0111.0111.1010.1010.0001.0001.1101
                        // = 0x077aa11d (4=Anzahl der Stellen)
    ```

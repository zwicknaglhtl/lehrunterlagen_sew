Erklärung Interface:




Bitoperationen: Kennen sie den Großteil schon aus einem anderen Fach und sollen wir uns mehr auf die Umsetzung in Java konzentrieren?

Aussage ZAI:

Ja, Bitoperationen hat BRE/HOR in der 1. in SEW gemacht. Ich habe es in GINF im 2. Jhg intensiv wiederholt. -> Foliensatz CPU S 42
Zweierkomplement sollte in Ginf im 1. Jhg unterrichtet werden. Auch das hab ich in GINF im 2. Jhg inteniv besprochen.
Seit letztem Jahr unterrichtet NOE alle drei 2. Klassen in GINF

Ideen:

Jedes Team hat sich eine Klasse und drei dazugehörige Objekte überlegt und dann einem anderen Team vorgestellt. (Zum Schluss haben wir die kreativste Klasse gekürt :-) )

geometrische Figuren als Klasse (Dreieck, Viereck,...) -> coole Klassenhierachie?

Hilft UML Notation beim Verständnis des doch sehr abstrakten Stoffs?

Wettbewerb 'Biber der Informatik


UML Beziehungen in einer weiteren Folie erklären (Assoziation, Aggregation, Komposition, Vererbung, Realisierung)

<!-- Beziehungen zwischen Klassen -->
      <section>
        <h2>Beziehungen</h2>
        <ul>
          <li><strong>Assoziation:</strong> Klasse A kennt Klasse B</li>
          <li><strong>Aggregation:</strong> Klasse A besteht aus Objekten von B</li>
          <li><strong>Vererbung:</strong> Klasse B erbt von Klasse A</li>
        </ul>
      </section>

      <!-- Beispiel Klassendiagramm -->
      <section>
        <h2>Beispiel</h2>
        <pre>
+---------------+         +-----------------+
|   Person      |<>------>|   Adresse       |
+---------------+         +-----------------+
| - name         |         | - strasse       |
| - alter        |         | - ort           |
+---------------+         +-----------------+
| + sagHallo()   |         
+---------------+
        </pre>
        <p>Person hat eine Adresse (Aggregation)</p>
      </section>
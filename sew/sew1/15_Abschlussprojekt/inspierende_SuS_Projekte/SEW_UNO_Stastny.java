package UNO;

/**
 * Alexadner Stastny
 * 11.5.2022
 * 1CI
 * UNO
 */

public class SEW_UNO_Stastny {
    public static final int CARD_NUMB = 7;
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static String getInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Methode, um auswahl des Spielers zu bekommen
     * @param message = Nachricht, um den Spieler nach Auswahl zu fragen
     * @param min = kleinste Zahl, welche ausgewählt werden kann
     * @param max = größte Zahl, welche ausgewählt werden kann
     * @return = auswahl als int
     */
    public static int getNumb(String message, int min, int max) {
        int output = 0;
        while (true) {
            String zwischen = getInput(message);
            if (zwischen.equals("Ende")) {
                System.exit(0);
            }
            if (zwischen.equals("Tanzverbot")) {
                return -2;
            }
            if (zwischen.length() < 1) {
                System.out.println("fehlerhafte Eingabe: den Punkt gibt es nicht");
                continue;
            }
            if (Character.isDigit(zwischen.charAt(0))) {
                output = Integer.parseInt(zwischen);
                if (output > max || output < min) {
                    System.out.println("fehlerhafte Eingabe: keine gueltige Zahl");
                    continue;
                }
                break;
            }
        }
        return output;
    }

    /**
     * Erstellt Kartendecks mit zufälligen Zahlen
     * @param pNumb = Spieleranzahl
     * @param cNumb = Karten pro Spieler
     * @return = 2D Array mit den Kartendecks
     */
    public static String[][] giveCards(int pNumb, int cNumb) {
        String[][] cardDecks = new String[pNumb][CARD_NUMB];
        for (int i = 0; i < pNumb; i++) {
            for (int j = 0; j < cNumb; j++) {
                if ((int) (Math.random() * (((20 - 1) + 1)) + 1) == 2) {
                    cardDecks[i][j] = "ss";
                    continue;
                }
                int rndNumb = (int) (Math.random() * (((49 - 11) + 1)) + 11);
                String rnNumb = Integer.toString(rndNumb);
                switch (rnNumb.charAt(0)) {
                    case '1' -> {
                        rnNumb = "r" + rnNumb.substring(1);
                    }
                    case '2' -> {
                        rnNumb = "g" + rnNumb.substring(1);
                    }
                    case '3' -> {
                        rnNumb = "y" + rnNumb.substring(1);
                    }
                    case '4' -> {
                        rnNumb = "b" + rnNumb.substring(1);
                    }
                }
                cardDecks[i][j] = rnNumb;
            }
        }
        return cardDecks;
    }

    /**
     * Überprüft ob diese Karte gelegt werden darf
     * @param stapelKarte = Karte auf dem Stapel
     * @param karte = Karte die gelegt werden soll
     * @return = true -> Karte ist legbar, false -> Karte ist nicht legbar
     */
    public static boolean istLegbar(String stapelKarte, String karte) {
        if (karte.charAt(1) == 's') {
            if (stapelKarte.charAt(1) != 's') {
                return true;
            } else {
                return false;
            }
        }
        if (stapelKarte.charAt(0) == karte.charAt(0) || stapelKarte.charAt(1) == karte.charAt(1)) {
            return true;
        }
        return false;
    }

    /**
     * Methode zum Ausgeben eines Kartendecks
     * @param cards = Kartendeck mit den Karten
     * @param nDeck = welches Deck ausgegeben werden soll
     */
    public static void printDeck(String[][] cards, int nDeck) {
        String farbe = "";
        String[] nulll = {
                " ________ ",
                "|0  __   |",
                "|  |  |  |",
                "|  |  |  |",
                "|  |  |  |",
                "|  |__|  |",
                "|       0|",
                "----------"
        };

        String[] eins = {
                " ________ ",
                "|1       |",
                "|   /|   |",
                "|  / |   |",
                "|    |   |",
                "|    |   |",
                "|       1|",
                "----------"
        };

        String[] zwoe = {
                " ________ ",
                "|2  _    |",
                "|  / \\   |",
                "|   _/   |",
                "|  /     |",
                "| /___   |",
                "|       2|",
                "----------"
        };

        String[] dree = {
                " ________ ",
                "|3  _    |",
                "|  / \\   |",
                "|   _/   |",
                "|    \\   |",
                "|  \\_/   |",
                "|       3|",
                "----------"
        };

        String[] four = {
                " ________ ",
                "|4       |",
                "|  /     |",
                "| /__|_  |",
                "|    |   |",
                "|    |   |",
                "|       4|",
                "----------"
        };

        String[] funf = {
                " ________ ",
                "|5 ____  |",
                "| |      |",
                "| |___   |",
                "|     \\  |",
                "| ____/  |",
                "|       5|",
                "----------"
        };

        String[] six = {
                " ________ ",
                "|6       |",
                "|    /   |",
                "|   /_   |",
                "|  /  \\  |",
                "|  \\__/  |",
                "|       6|",
                "----------"
        };

        String[] seven = {
                " ________ ",
                "|7 ____  |",
                "|     /  |",
                "|    /   |",
                "|   /    |",
                "|  /     |",
                "|       7|",
                "----------"
        };

        String[] acht = {
                " ________ ",
                "|8  __   |",
                "|  /  \\  |",
                "|  \\__/  |",
                "|  /  \\  |",
                "|  \\__/  |",
                "|       8|",
                "----------"
        };

        String[] nein = {
                " ________ ",
                "|9  __   |",
                "|  /  \\  |",
                "|  \\__/  |",
                "|    /   |",
                "|   /    |",
                "|       9|",
                "----------"
        };

        String[] leer = {
                "          ",
                "          ",
                "          ",
                "          ",
                "          ",
                "          ",
                "          ",
                "          ",
        };
        String[] schwarz = {
                " ________ ",
                "|S       |",
                "|        |",
                "|        |",
                "|        |",
                "|        |",
                "|       S|",
                "----------"
        };

        for (int i = 0; i < eins.length; i++) {
            for (int j = 0; j < cards[nDeck].length; j++) {
                switch (cards[nDeck][j].charAt(0)) {
                    case 'r' -> {
                        farbe = "\u001B[31m";
                    }
                    case 'g' -> {
                        farbe = "\u001B[32m";
                    }
                    case 'y' -> {
                        farbe = "\u001B[33m";
                    }
                    case 'b' -> {
                        farbe = "\u001B[34m";
                    }
                    case 's' -> {
                        farbe = "\u001B[37m";
                    }
                }
                switch (cards[nDeck][j].charAt(1)) {
                    case '0' -> {
                        System.out.print(farbe + nulll[i] + " ");
                    }
                    case '1' -> {
                        System.out.print(farbe + eins[i] + " ");
                    }
                    case '2' -> {
                        System.out.print(farbe + zwoe[i] + " ");
                    }
                    case '3' -> {
                        System.out.print(farbe + dree[i] + " ");
                    }
                    case '4' -> {
                        System.out.print(farbe + four[i] + " ");
                    }
                    case '5' -> {
                        System.out.print(farbe + funf[i] + " ");
                    }
                    case '6' -> {
                        System.out.print(farbe + six[i] + " ");
                    }
                    case '7' -> {
                        System.out.print(farbe + seven[i] + " ");
                    }
                    case '8' -> {
                        System.out.print(farbe + acht[i] + " ");
                    }
                    case '9' -> {
                        System.out.print(farbe + nein[i] + " ");
                    }
                    case 'l' -> {
                        System.out.print(leer[i] + " ");
                    }
                    case 's' -> {
                        System.out.print(schwarz[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * Methode zum Ausgeben eines Kartendecks
     * @param cards = Karten, die ausgegeben werden sollen
     */
    public static void printDeck(String[] cards) {
        String farbe = "";
        String[] nulll = {
                " ________ ",
                "|0  __   |",
                "|  |  |  |",
                "|  |  |  |",
                "|  |  |  |",
                "|  |__|  |",
                "|       0|",
                "----------"
        };

        String[] eins = {
                " ________ ",
                "|1       |",
                "|   /|   |",
                "|  / |   |",
                "|    |   |",
                "|    |   |",
                "|       1|",
                "----------"
        };

        String[] zwoe = {
                " ________ ",
                "|2  _    |",
                "|  / \\   |",
                "|   _/   |",
                "|  /     |",
                "| /___   |",
                "|       2|",
                "----------"
        };

        String[] dree = {
                " ________ ",
                "|3  _    |",
                "|  / \\   |",
                "|   _/   |",
                "|    \\   |",
                "|  \\_/   |",
                "|       3|",
                "----------"
        };

        String[] four = {
                " ________ ",
                "|4       |",
                "|  /     |",
                "| /__|_  |",
                "|    |   |",
                "|    |   |",
                "|       4|",
                "----------"
        };

        String[] funf = {
                " ________ ",
                "|5 ____  |",
                "| |      |",
                "| |___   |",
                "|     \\  |",
                "| ____/  |",
                "|       5|",
                "----------"
        };

        String[] six = {
                " ________ ",
                "|6       |",
                "|    /   |",
                "|   /_   |",
                "|  /  \\  |",
                "|  \\__/  |",
                "|       6|",
                "----------"
        };

        String[] seven = {
                " ________ ",
                "|7 ____  |",
                "|     /  |",
                "|    /   |",
                "|   /    |",
                "|  /     |",
                "|       7|",
                "----------"
        };

        String[] acht = {
                " ________ ",
                "|8  __   |",
                "|  /  \\  |",
                "|  \\__/  |",
                "|  /  \\  |",
                "|  \\__/  |",
                "|       8|",
                "----------"
        };

        String[] nein = {
                " ________ ",
                "|9  __   |",
                "|  /  \\  |",
                "|  \\__/  |",
                "|    /   |",
                "|   /    |",
                "|       9|",
                "----------"
        };

        String[] leer = {
                "          ",
                "          ",
                "          ",
                "          ",
                "          ",
                "          ",
                "          ",
                "          ",
        };

        String[] schwarz = {
                " ________ ",
                "|S       |",
                "|        |",
                "|        |",
                "|        |",
                "|        |",
                "|       S|",
                "----------"
        };

        for (int i = 0; i < eins.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                switch (cards[j].charAt(0)) {
                    case 'r' -> {
                        farbe = "\u001B[31m";
                    }
                    case 'g' -> {
                        farbe = "\u001B[32m";
                    }
                    case 'y' -> {
                        farbe = "\u001B[33m";
                    }
                    case 'b' -> {
                        farbe = "\u001B[34m";
                    }
                    case 's' -> {
                        farbe = "\u001B[37m";
                    }
                }
                switch (cards[j].charAt(1)) {
                    case '0' -> {
                        System.out.print(farbe + nulll[i] + " ");
                    }
                    case '1' -> {
                        System.out.print(farbe + eins[i] + " ");
                    }
                    case '2' -> {
                        System.out.print(farbe + zwoe[i] + " ");
                    }
                    case '3' -> {
                        System.out.print(farbe + dree[i] + " ");
                    }
                    case '4' -> {
                        System.out.print(farbe + four[i] + " ");
                    }
                    case '5' -> {
                        System.out.print(farbe + funf[i] + " ");
                    }
                    case '6' -> {
                        System.out.print(farbe + six[i] + " ");
                    }
                    case '7' -> {
                        System.out.print(farbe + seven[i] + " ");
                    }
                    case '8' -> {
                        System.out.print(farbe + acht[i] + " ");
                    }
                    case '9' -> {
                        System.out.print(farbe + nein[i] + " ");
                    }
                    case 'l' -> {
                        System.out.print(leer[i] + " ");
                    }
                    case 's' -> {
                        System.out.print(farbe + schwarz[i] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * Methode zum ausgeben eines Menüs
     */
    public static void printMenue() {
        System.out.println("                                                          .,*(###(/,.                               \n" +
                "                                               /##############################(                     \n" +
                "                                         /##############################*  .(@@&%#%&@@%,            \n" +
                "                                    /################################  /@/ ............, ,@#        \n" +
                "                                (##########################*  ####  #@*......................@      \n" +
                "                            ,#######################(.   #@@#% #  @@(......, ,&@@@@@%. ....... @    \n" +
                "                         ,#######################(  @@. .,...(& @@@,,......@@@@@@@@@@#%@ ,..... @.  \n" +
                "                       ###############%*  #####, /@###@ ......#@@@#....../@     .@@#####@#...... @. \n" +
                "                    /###########/   .%@@*@%  ,## *@###%@ ,.....&@@...... &. ###### *@#&@&&(.......& \n" +
                "                  #######(,   (@@@@ .,..... /@(   (&@@%#@ ..... %@,......#% #######, @%#&@@ ...., @ \n" +
                "                ######. (@@. .,..(@@ .......... #@*#&#@@@@ ..... @@ ..... @* ####### .@@@@&...... & \n" +
                "               (###%  @%##@ ......#@& ............. %@@@@@@ ..... @# .......@  #####  @@@#...... @. \n" +
                "          #@@(@ ###% /@####@ ,.....&@& .....  ,........ &@@@ ..... @@ ,...... #@%(*(@@& ....... @   \n" +
                "     @@. .,.../& (##( %&#@@#@ ..... &@%...... @@ .,......,  & ..... @@# ,.........,.......... /@    \n" +
                "  /@@@@@ ,...../@ %##( #&##@@@ ..... @@(....., @@@@& ........,....., @@@@. ,.............,  @@      \n" +
                "  *@@@@@@ ,.....%# ###/ %@@@@@@ ..... @@(....., @@@@@@@( ..........., @@@@@@@%,       ,%@@@@        \n" +
                "   *@@@@@@ ..... #% ###* @@@@@@@ ..... @@,....., @@@@@@@@@@* ........, @@@@@@@@@@@@@@@@@%           \n" +
                "    #@@@@@@ ..... @/ ###* &@@@@@% ..... @@,,....,.@%@@@@@@@@@@@  ...., .@.&@@@@@@@@/                \n" +
                "     #@@###@ ..... @/ ###. @@@@@@,,.....%@@.,..... @   &@@@@@@@@@@@@@@@& .##########                \n" +
                "      &%###%@ ..... @/ ###. @@@@@ ,.....(@@@ .....,*% (#. .@@@@@@@@@#  (##########                  \n" +
                "       &%%@&%@ ......,@.  , %@@@ ,..... @@@@@ ,... .#@ (####  .   *############(                    \n" +
                "        @##%@@@ ........  .   ,....... @@@@@@@@@@@@@  #######################                       \n" +
                "         @@@@@@@% .................. @/ *@@@@@@@/  *######################,                         \n" +
                "          #@@@@@@@@, ........,. .%@@  (# #.  ./########################.                            \n" +
                "            @@@@@@@@@@@@@@@@@@@@@/ .###############################/                                \n" +
                "               &@@@@@@@@@@@@@(  ,#############################%.                                    \n" +
                "                          ./#############################(.                                         \n" +
                "                       /##########################(.                                                \n" +
                "                                                                                      \n" +
                "\n");
        System.out.println(
                "          1* Spielregeln \n" +
                        "          2* Spielen");
    }

    /**
     * Methode zum ausgeben der Regeln
     */
    public static void printRegeln() {
        System.out.println("\n\nUNO-Spieleregeln:\n" +
                "\n" +
                "Am Anfang jeder Runde bekommt jeder Spieler 7 zufällige Karten.\n" +
                "Falls ein Spieler im laufe einer Runde mehr als 29 Karten hat," +
                "verliert dieser automatisch" +
                "Die Karten gehen von 0-9 und können die Farben rot, gelb, grün\n" +
                "ung blau annehmen. Es gibt auch eine schwarze Karte. Diese ist\n" +
                "besonders, da sie jede Farbe annehmen kann, welche der Spieler\n" +
                "will. \n" +
                "Das Ziel dieses Spiels ist es, alle Karten\n" +
                "so schnell wie möglich loszuwerden.\n" +
                "\n" +
                "\n" +
                "Wie funktioniert das Spiel und wie werde ich meine Karten los?\n" +
                "\n" +
                "UNO ist ein rundenbasiertes Spiel. In jeder Runde kommt jeder\n" +
                "Spieler einmal dran. Wenn ein Spieler dran ist, hat er genau \n" +
                "zwei Optionen. \n" +
                "1: Er kann eine Karte auf den Stapel legen. Dafür muss jedoch\n" +
                "die Karte, welche der Spieler legen will die selbe Zahl oder\n" +
                "die selbe Farbe haben. WICHTIG: schwarze Karten können nicht\n" +
                "auf schwarze Karten gelegt werden.\n" +
                "2: Er kann sich eine Karte ziehen. Falls keine Karte gelegt\n" +
                "werden kann oder der Spieler aus irgendeinem Grund keine\n" +
                "Karte legen will, muss er sich eine Karte ziehen.\n\n" +
                "Falls das Spiel beendet werden soll, kann \"Ende\" eingegeben" +
                "werden. Falls zufälligerweise mitten im Spiel\"Tanzverbot\"" +
                "eingegeben wird, könnten interesannte Sachen passieren");
    }

    /**
     * Methode zum ausgeben des Sichtschutzes
     */
    public static void printSichtschutz() {
        System.out.println("                                                                                                    \n" +
                "                                                                                                    \n" +
                "    \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "                                                                                                \n" +
                "                                                                                                    \n" +
                "                 .         .                    . .      .                                          \n" +
                "                   .@@@@@%   ..........  *@& ,(.     @@    ............  %@*  ...                   \n" +
                "                   ,@@  @@,  (#*  .,.*#, .@ ,@@#,    @@      /#*    ((*  #@/  ,,  .                 \n" +
                "                   ,@@  @@,%@# &@*(@@ #@&    @@*     @@    &@# &@*%@/ @@,#@/(@%                     \n" +
                "                   ,@@  @@,&@* %@/(@% (@&    &@,     @@    &@* %@*&@. %@*#@@@@.  .                  \n" +
                "                   ,@@  @@,&@/ &@/(@% (@&    &@,     @@    &@* &@*&@, %@*#@( @@.  .                 \n" +
                "                   .&&&&%   #@@&, /&# /&#     &@@    &&&&&/ %@@&,  #@@&, (&* .&&  .                 \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@@@@@@@@@%,         .                  \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@@@@@@@@@@@@@@@.   .                   \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@@@@@@@@@@@@@@@@@*                     \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@@@@@@@@@@@@@@@@@@#                    \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,       %@@@@@@@@@                    \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,        &@@@@@@@@%  .                \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,        &@@@@@@@@@  .                \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,        &@@@@@@@@@  .                \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,        &@@@@@@@@@  .                \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,        &@@@@@@@@%  .                \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,       #@@@@@@@@@   .                \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@@@@@@@@@@@@@@@@@@#  .                 \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@@@@@@@@@@@@@@@@@/                     \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@@@@@@@@@@@@@@@    .                   \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@@@@@@@%(/.                            \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,        ...                          \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,  .                                  \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,  .                                  \n" +
                "                   ,@@@@@@@@@         *@@@@@@@@&     @@@@@@@@@,  .                                  \n" +
                "                   ,@@@@@@@@@         /@@@@@@@@%     @@@@@@@@@,  .                                  \n" +
                "                    @@@@@@@@@@       .@@@@@@@@@,     @@@@@@@@@,  .                                  \n" +
                "                 .   @@@@@@@@@@@@@@@@@@@@@@@@@#  .   @@@@@@@@@,  .                                  \n" +
                "                  .   @@@@@@@@@@@@@@@@@@@@@@@/   .   @@@@@@@@@,  .                                  \n" +
                "                        &@@@@@@@@@@@@@@@@@@,   .     @@@@@@@@@,  .                                  \n" +
                "                      .     .(@@@@@@@&*      .                                                      \n" +
                "                          ..           ..           ...........                                     \n" +
                "                                                                              \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "       ");
    }

    /**
     * Methode zum ausgeben des Gewinnscreens
     * @param Spieler = welcher Spieler gewonnen hat
     */
    public static void printGewinnscreen(int Spieler) {
        System.out.println("                                                                                                    \n" +
                "                                                                                                    \n" +
                "                              ,,,............,,,,,,,,,,,......,,,,,,,*                              \n" +
                "                              ,,,,,.,,,,,,,,,,,,,,,,,,,,,,,,,,,********                             \n" +
                "                              ,,,     ,,,,,,,,,,,,,,,,,,,,,,,,,********                             \n" +
                "                 .,,,*********,,,,. ,,*,,,,,,,,,,,,,,,,,,,,,,,,*****************,,,                 \n" +
                "                 .,,,         ,,,,,,,,.  ,,,,,,,,,,,,,,,,,,,,,,********         ,,,                 \n" +
                "                  ,,,         ,,,,,,,,,,,,,,,,,,,,**,,,,,,,,,,,********         ,,,                 \n" +
                "                  ,,,.        ,,,,,,,,,,,,,,,,,,*****,,,,,,,,,,********        ,,,,                 \n" +
                "                  ,,,,        ,,,,,,,,,,,,*****************,,,,*******         ,,,.                 \n" +
                "                   ,,,.        ,,,,,,,,,,,,,,***********,,,,,,********        ,,,,                  \n" +
                "                    ,,,.        ,,,,,,,,,,,,,,*********,,,,,,,*******        ,,,,                   \n" +
                "                     ,*,,       .,,,,,,,,,,,,,****,*****,,,,,*******        ,,,,                    \n" +
                "                      .,,,,.     .,,,,,,,,,,,,,,,,,,,,,,,,,,,******      .,,,*                      \n" +
                "                         **,,,,,,  ,,,,,,,,,,,,,,,,,,,,,,,,,******  ,,,,,,,*                        \n" +
                "                             ,*,,,,,,,,,,,,,,,,,,,,,,,,,,,,******,,*,**.                            \n" +
                "                                      ,,,,,,,,,,,,,,,,,,,,****.                                     \n" +
                "                                         ,,,,,,,,,,,,,,,****                                        \n" +
                "                                             ,,,,,,,,,*,                                            \n" +
                "                                               .,,,,*                                               \n" +
                "                                               ,,,,,*.                                              \n" +
                "                                               ,,,,,**                                              \n" +
                "                                              ,,,,,,**,                                             \n" +
                "                                             ,,,,,,,,**.                                            \n" +
                "                                        *,,,,,,,,,,,,,,,,****                                       \n" +
                "                                      **,,,********************                                     \n" +
                "                               %%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&#                              \n" +
                "                               %%%#,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&&&#                              \n" +
                "                               %%%#,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&&&#                              \n" +
                "                               %%%#,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&&&#                              \n" +
                "                               %%%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#                              \n" +
                "                            %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&(                           \n" +
                "                                                                                   \n" +
                "                             Spieler " + Spieler + " hat gewonnen!!!!!!!\n\n" +
                "1* nochmal Spielen\n2* zurück zum Menue");
    }

    /**
     * Methode zum ausgeben des Spielendescreens
     */
    public static void printSpieleende() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@. . ....... . .. .... ....... ............. ....... .. .... .. . .. .... .. ..... .... .. .. @@@\n" +
                "@@.................................................................................................@\n" +
                "@@.................................................................................................@\n" +
                "@@.................................................................................................@\n" +
                "@@............@@@@@@@@@@@@@@@@....@@@@@@@@@@@@@@....@@@@@@......@@@@@@..@@@@@@@@@@@@@@@@@@.........@\n" +
                "@@..........@@@@@@@@@@@@@@@@@@..@@@@@@@@@@@@@@@@@@..@@@@@@@@..@@@@@@@@..@@@@@@@@@@@@@@@@@@.........@\n" +
                "@@..........@@@@@@..@@@@@@@@@@. @@@@@@..... @@@@@@..@@@@@@@@@@@@@@@@@@..@@@@@@@@@@@@@@@@@@.........@\n" +
                "@@..........@@@@@@..@@@@@@@@@@..@@@@@@@@@@@@@@@@@@..@@@@@@@@@@@@@@@@@@..@@@@@@@@@@@@@@@@@@.........@\n" +
                "@@..........@@@@@@......@@@@@@. @@@@@@@@@@@@@@@@@@..@@@@@@..@@..@@@@@@..@@@@@@.....................@\n" +
                "@@..........@@@@@@@@@@@@@@@@@@. @@@@@@..... @@@@@@..@@@@@@......@@@@@@..@@@@@@@@@@@@@@@@@@.........@\n" +
                "@@............((((((((((((((....((((((....../(((((..(((((( .....((((((..((((((((((((((((((.........@\n" +
                "@@.................................................................................................@\n" +
                "@@..................................................................... ...........................@\n" +
                "@@..........  @@@@@@@@@@@@@@  ..@@@@@@......@@@@@@..@@@@@@@@@@@@@@@@@@..@@@@@@@@@@@@@@@@  .........@\n" +
                "@@..........@@@@@@......@@@@@@..@@@@@@......@@@@@@..@@@@@@..............@@@@@@......@@@@@@.........@\n" +
                "@@..........@@@@@@......@@@@@@. @@@@@@......@@@@@@..@@@@@@@@@@@@@@@@@@..@@@@@@@@@@@@@@@@...........@\n" +
                "@@..........@@@@@@......@@@@@@. @@@@@@@@. @@@@@@@@..@@@@@@@@@@@@@@@@@@..@@@@@@@@@@@@@@ ............@\n" +
                "@@..........@@@@@@......@@@@@@....@@@@@@@@@@@@@@....@@@@@@..............@@@@@@..@@@@@@@@ ..........@\n" +
                "@@............@@@@@@@@@@@@@@. ........@@@@@@........@@@@@@@@@@@@@@@@@@..@@@@@@......@@@@@@.........@\n" +
                "@@.................................................................................................@\n" +
                "@@.................................................................................................@\n" +
                "@@.................................................................................................@\n" +
                "@@@@ ............................................................................................@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                "\n" +
                "Das waren wohl zu viele Karten\n\n" +
                "1* nochmal spielen\n2* zurück zum Menue");
    }

    public static void main(String[] args) {
        LOOP_0:
        while (true) {
        printMenue();
        LOOP_1:
        while (true) {
            int auwahl = getNumb("Welchen Menüpunkt wählst du? ", 1, 2);
            switch (auwahl) {
                case 1 -> {
                    printRegeln();
                }
                case 2 -> {
                    break LOOP_1;
                }
            }
            getInput("");
            System.out.println(" \n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    " ");
            printMenue();
        }
        System.out.println("\n\n\n");
        int pNumb = getNumb("          Spieleranzahl (2-6): ", 2, 6);
        LOOP_2:
        while (true) {
            String[][] decks = giveCards(pNumb, CARD_NUMB);
            String stapelCard = giveCards(1, 1)[0][0];
            if (stapelCard.equals("ss")) {
                switch ((int) (Math.random() * 3)) {
                    case 0 -> {
                        stapelCard = "rs";
                    }
                    case 1 -> {
                        stapelCard = "gs";
                    }
                    case 2 -> {
                        stapelCard = "bs";
                    }
                    case 3 -> {
                        stapelCard = "ys";
                    }
                }
            }
            String[] stapel = {"bl", "bl", "bl", "bl", stapelCard};
            String[] deck1 = new String[7];
            String[] deck2 = new String[7];
            String[] deck3 = new String[7];
            String[] deck4 = new String[7];
            String[] deck5 = new String[7];
            String[] deck6 = new String[7];

            deck1 = decks[0];
            if (pNumb >= 2) {
                deck2 = decks[1];
            }
            if (pNumb >= 3) {
                deck3 = decks[2];
            }
            if (pNumb >= 4) {
                deck4 = decks[3];
            }
            if (pNumb >= 5) {
                deck5 = decks[4];
            }
            if (pNumb >= 6) {
                deck6 = decks[5];
            }

            System.out.println("\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n");
            while (true) {
                LOOP_1:
                while (true) {
                    printDeck(stapel);
                    System.out.println("\n\n");
                    printDeck(deck1);
                    for (int j = 1; j <= deck1.length; j++) {
                        System.out.printf("\u001B[0m   %02d      ", j);
                    }
                    ;
                    int auswahl = getNumb("Welche Karte willst du legen (Falls du eine Karte ziehen willst, 0 eingeben)", 0, deck1.length);
                    if (auswahl == -1) {
                        System.exit(0);
                    }
                    if (auswahl == -2) {
                        for (int i = 0; i < deck1.length; i++) {
                            deck1[i] = "ss";
                        }
                        auswahl = 1;
                    }
                    if (auswahl == 0) {
                        String[] deck1C = new String[deck1.length + 1];
                        for (int i = 0; i < deck1.length; i++) {
                            deck1C[i] = deck1[i];
                        }
                        deck1C[deck1C.length - 1] = giveCards(1, 1)[0][0];
                        deck1 = deck1C;
                        break LOOP_1;
                    }
                    if (istLegbar(stapelCard, deck1[auswahl - 1])) {
                        String[] deckC1 = new String[deck1.length - 1];
                        int c = 0;
                        for (int i = 0; i < deckC1.length; i++) {
                            if (i == auswahl - 1) {
                                c++;
                            }
                            deckC1[i] = deck1[c];
                            c++;
                        }
                        if (deck1[auswahl - 1].equals("ss")) {
                            int newColor = getNumb("Welche Farbe willst du?  \u001B[31m 1  \u001B[32m 2  \u001B[34m 3  \u001B[33m 4", 1, 4);
                            switch (newColor) {
                                case 1-> {
                                    stapelCard = "rs";
                                }
                                case 2-> {
                                    stapelCard = "gs";
                                }
                                case 3-> {
                                    stapelCard = "bs";
                                }
                                case 4-> {
                                    stapelCard = "ys";
                                }
                            }
                            stapel[stapel.length - 1] = stapelCard;
                            deck1 = deckC1;
                            break LOOP_1;
                        }
                        stapelCard = deck1[auswahl - 1];
                        stapel[stapel.length - 1] = stapelCard;
                        deck1 = deckC1;
                        break LOOP_1;
                    }
                }
                if (deck1.length >= 30) {
                    printSpieleende();
                    int wahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                    switch (wahl) {
                        case 1 -> {
                            continue LOOP_2;
                        }
                        case 2 -> {
                            System.out.println("\u001B[0m");
                            continue LOOP_0;
                        }
                    }
                }

                if (deck1.length == 0) {
                    printGewinnscreen(1);
                    int auswahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                    switch (auswahl) {
                        case 1 -> {
                            continue LOOP_2;
                        }
                        case 2 -> {
                            System.out.println("\u001B[0m");
                            continue LOOP_0;
                        }
                    }
                }
                printSichtschutz();
                getInput("");


                LOOP_1:
                while (true) {
                    printDeck(stapel);
                    System.out.println("\n\n");
                    printDeck(deck2);
                    for (int j = 1; j <= deck2.length; j++) {
                        System.out.printf("\u001B[0m   %02d      ", j);
                    }
                    ;
                    int auswahl = getNumb("Wel" +
                            "Welche Karte willst du legen (Falls du eine Karte ziehen willst, 0 eingeben)", 0, deck2.length);
                    if (auswahl == -1) {
                        System.exit(0);
                    }
                    if (auswahl == -2) {
                        for (int i = 0; i < deck2.length; i++) {
                            deck2[i] = "ss";
                        }
                        auswahl = 1;
                    }
                    if (auswahl == 0) {
                        String[] deck2C = new String[deck2.length + 1];
                        for (int i = 0; i < deck2.length; i++) {
                            deck2C[i] = deck2[i];
                        }
                        deck2C[deck2C.length - 1] = giveCards(1, 1)[0][0];
                        deck2 = deck2C;
                        break LOOP_1;
                    }
                    if (istLegbar(stapelCard, deck2[auswahl - 1])) {
                        String[] deckC2 = new String[deck2.length - 1];
                        int c = 0;
                        for (int i = 0; i < deckC2.length; i++) {
                            if (i == auswahl - 1) {
                                c++;
                            }
                            deckC2[i] = deck2[c];
                            c++;
                        }
                        if (deck2[auswahl - 1].equals("ss")) {
                            int newColor = getNumb("Welche Farbe willst du?  \u001B[31m 1  \u001B[32m 2  \u001B[34m 3  \u001B[33m 4", 1, 4);
                            switch (newColor) {
                                case 1-> {
                                    stapelCard = "rs";
                                }
                                case 2-> {
                                    stapelCard = "gs";
                                }
                                case 3-> {
                                    stapelCard = "bs";
                                }
                                case 4-> {
                                    stapelCard = "ys";
                                }
                            }
                            stapel[stapel.length - 1] = stapelCard;
                            deck2 = deckC2;
                            break LOOP_1;
                        }
                        stapelCard = deck2[auswahl - 1];
                        stapel[stapel.length - 1] = stapelCard;
                        deck2 = deckC2;
                        break LOOP_1;
                    }
                }
                if (deck2.length >= 30) {
                    printSpieleende();
                    int wahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                    switch (wahl) {
                        case 1 -> {
                            continue LOOP_2;
                        }
                        case 2 -> {
                            System.out.println("\u001B[0m");
                            continue LOOP_0;
                        }
                    }
                }

                if (deck2.length == 0) {
                    printGewinnscreen(2);
                    int auswahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                    switch (auswahl) {
                        case 1 -> {
                            continue LOOP_2;
                        }
                        case 2 -> {
                            System.out.println("\u001B[0m");
                            continue LOOP_0;
                        }
                    }
                }
                printSichtschutz();
                getInput("");


                if (pNumb >= 3) {
                    LOOP_1:
                    while (true) {
                        printDeck(stapel);
                        System.out.println("\n\n");
                        printDeck(deck3);
                        for (int j = 1; j <= deck3.length; j++) {
                            System.out.printf("\u001B[0m   %02d      ", j);
                        }
                        ;
                        int auswahl = getNumb("Wel" +
                                "Welche Karte willst du legen (Falls du eine Karte ziehen willst, 0 eingeben)", 0, deck3.length);
                        if (auswahl == -1) {
                            System.exit(0);
                        }
                        if (auswahl == -2) {
                            for (int i = 0; i < deck3.length; i++) {
                                deck3[i] = "ss";
                            }
                            auswahl = 1;
                        }
                        if (auswahl == 0) {
                            String[] deck3C = new String[deck3.length + 1];
                            for (int i = 0; i < deck3.length; i++) {
                                deck3C[i] = deck3[i];
                            }
                            deck3C[deck3C.length - 1] = giveCards(1, 1)[0][0];
                            deck3 = deck3C;
                            break LOOP_1;
                        }
                        if (istLegbar(stapelCard, deck3[auswahl - 1])) {
                            String[] deckC3 = new String[deck3.length - 1];
                            int c = 0;
                            for (int i = 0; i < deckC3.length; i++) {
                                if (i == auswahl - 1) {
                                    c++;
                                }
                                deckC3[i] = deck3[c];
                                c++;
                            }
                            if (deck3[auswahl - 1].equals("ss")) {
                                int newColor = getNumb("Welche Farbe willst du?  \u001B[31m 1  \u001B[32m 2  \u001B[34m 3  \u001B[33m 4", 1, 4);
                                switch (newColor) {
                                    case 1-> {
                                        stapelCard = "rs";
                                    }
                                    case 2-> {
                                        stapelCard = "gs";
                                    }
                                    case 3-> {
                                        stapelCard = "bs";
                                    }
                                    case 4-> {
                                        stapelCard = "ys";
                                    }
                                }
                                stapel[stapel.length - 1] = stapelCard;
                                deck3 = deckC3;
                                break LOOP_1;
                            }
                            stapelCard = deck3[auswahl - 1];
                            stapel[stapel.length - 1] = stapelCard;
                            deck3 = deckC3;
                            break LOOP_1;
                        }
                    }
                    if (deck2.length >= 30) {
                        printSpieleende();
                        int wahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                        switch (wahl) {
                            case 1 -> {
                                continue LOOP_2;
                            }
                            case 2 -> {
                                System.out.println("\u001B[0m");
                                continue LOOP_0;
                            }
                        }
                    }

                    if (deck3.length == 0) {
                        printGewinnscreen(3);
                        int auswahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                        switch (auswahl) {
                            case 1 -> {
                                continue LOOP_2;
                            }
                            case 2 -> {
                                System.out.println("\u001B[0m");
                                continue LOOP_0;
                            }
                        }
                    }
                    printSichtschutz();
                    getInput("");


                    if (pNumb >= 4) {
                        LOOP_1:
                        while (true) {
                            printDeck(stapel);
                            System.out.println("\n\n");
                            printDeck(deck4);
                            for (int j = 1; j <= deck4.length; j++) {
                                System.out.printf("\u001B[0m   %02d      ", j);
                            }
                            ;
                            int auswahl = getNumb("Wel" +
                                    "Welche Karte willst du legen (Falls du eine Karte ziehen willst, 0 eingeben)", 0, deck4.length);
                            if (auswahl == -1) {
                                System.exit(0);
                            }
                            if (auswahl == -2) {
                                for (int i = 0; i < deck4.length; i++) {
                                    deck4[i] = "ss";
                                }
                                auswahl = 1;
                            }
                            if (auswahl == 0) {
                                String[] deck4C = new String[deck4.length + 1];
                                for (int i = 0; i < deck4.length; i++) {
                                    deck4C[i] = deck4[i];
                                }
                                deck4C[deck4C.length - 1] = giveCards(1, 1)[0][0];
                                deck4 = deck4C;
                                break LOOP_1;
                            }
                            if (istLegbar(stapelCard, deck4[auswahl - 1])) {
                                String[] deckC4 = new String[deck4.length - 1];
                                int c = 0;
                                for (int i = 0; i < deckC4.length; i++) {
                                    if (i == auswahl - 1) {
                                        c++;
                                    }
                                    deckC4[i] = deck4[c];
                                    c++;
                                }
                                if (deck4[auswahl - 1].equals("ss")) {
                                    int newColor = getNumb("Welche Farbe willst du?  \u001B[31m 1  \u001B[32m 2  \u001B[34m 3  \u001B[33m 4", 1, 4);
                                    switch (newColor) {
                                        case 1-> {
                                            stapelCard = "rs";
                                        }
                                        case 2-> {
                                            stapelCard = "gs";
                                        }
                                        case 3-> {
                                            stapelCard = "bs";
                                        }
                                        case 4-> {
                                            stapelCard = "ys";
                                        }
                                    }
                                    stapel[stapel.length - 1] = stapelCard;
                                    deck4 = deckC4;
                                    break LOOP_1;
                                }
                                stapelCard = deck4[auswahl - 1];
                                stapel[stapel.length - 1] = stapelCard;
                                deck4 = deckC4;
                                break LOOP_1;
                            }
                        }
                        if (deck4.length >= 30) {
                            printSpieleende();
                            int wahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                            switch (wahl) {
                                case 1 -> {
                                    continue LOOP_2;
                                }
                                case 2 -> {
                                    System.out.println("\u001B[0m");
                                    continue LOOP_0;
                                }
                            }
                        }

                        if (deck4.length == 0) {
                            printGewinnscreen(4);
                            int auswahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                            switch (auswahl) {
                                case 1 -> {
                                    continue LOOP_2;
                                }
                                case 2 -> {
                                    System.out.println("\u001B[0m");
                                    continue LOOP_0;
                                }
                            }
                        }
                        printSichtschutz();
                        getInput("");


                        if (pNumb >= 5) {
                            LOOP_1:
                            while (true) {
                                printDeck(stapel);
                                System.out.println("\n\n");
                                printDeck(deck5);
                                for (int j = 1; j <= deck5.length; j++) {
                                    System.out.printf("\u001B[0m   %02d      ", j);
                                }
                                ;
                                int auswahl = getNumb("Wel" +
                                        "Welche Karte willst du legen (Falls du eine Karte ziehen willst, 0 eingeben)", 0, deck5.length);
                                if (auswahl == -1) {
                                    System.exit(0);
                                }
                                if (auswahl == -2) {
                                    for (int i = 0; i < deck5.length; i++) {
                                        deck5[i] = "ss";
                                    }
                                    auswahl = 1;
                                }
                                if (auswahl == 0) {
                                    String[] deck5C = new String[deck5.length + 1];
                                    for (int i = 0; i < deck5.length; i++) {
                                        deck5C[i] = deck5[i];
                                    }
                                    deck5C[deck5C.length - 1] = giveCards(1, 1)[0][0];
                                    deck5 = deck5C;
                                    break LOOP_1;
                                }
                                if (istLegbar(stapelCard, deck5[auswahl - 1])) {
                                    String[] deckC5 = new String[deck5.length - 1];
                                    int c = 0;
                                    for (int i = 0; i < deckC5.length; i++) {
                                        if (i == auswahl - 1) {
                                            c++;
                                        }
                                        deckC5[i] = deck5[c];
                                        c++;
                                    }
                                    if (deck5[auswahl - 1].equals("ss")) {
                                        int newColor = getNumb("Welche Farbe willst du?  \u001B[31m 1  \u001B[32m 2  \u001B[34m 3  \u001B[33m 4", 1, 4);
                                        switch (newColor) {
                                            case 1 -> {
                                                stapelCard = "rs";
                                            }
                                            case 2 -> {
                                                stapelCard = "gs";
                                            }
                                            case 3 -> {
                                                stapelCard = "bs";
                                            }
                                            case 4 -> {
                                                stapelCard = "ys";
                                            }
                                        }
                                        stapel[stapel.length - 1] = stapelCard;
                                        deck5 = deckC5;
                                        break LOOP_1;
                                    }
                                    stapelCard = deck5[auswahl - 1];
                                    stapel[stapel.length - 1] = stapelCard;
                                    deck5 = deckC5;
                                    break LOOP_1;
                                }
                            }
                            if (deck5.length >= 30) {
                                printSpieleende();
                                int wahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                                switch (wahl) {
                                    case 1 -> {
                                        continue LOOP_2;
                                    }
                                    case 2 -> {
                                        System.out.println("\u001B[0m");
                                        continue LOOP_0;
                                    }
                                }
                            }

                            if (deck5.length == 0) {
                                printGewinnscreen(5);
                                int auswahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                                switch (auswahl) {
                                    case 1 -> {
                                        continue LOOP_2;
                                    }
                                    case 2 -> {
                                        System.out.println("\u001B[0m");
                                        continue LOOP_0;
                                    }
                                }
                            }
                            printSichtschutz();
                            getInput("");


                            if (pNumb == 6) {
                                LOOP_1:
                                while (true) {
                                    printDeck(stapel);
                                    System.out.println("\n\n");
                                    printDeck(deck6);
                                    for (int j = 1; j <= deck6.length; j++) {
                                        System.out.printf("\u001B[0m   %02d      ", j);
                                    }
                                    ;
                                    int auswahl = getNumb("Wel" +
                                            "Welche Karte willst du legen (Falls du eine Karte ziehen willst, 0 eingeben)", 0, deck6.length);
                                    if (auswahl == -1) {
                                        System.exit(0);
                                    }
                                    if (auswahl == -2) {
                                        for (int i = 0; i < deck6.length; i++) {
                                            deck6[i] = "ss";
                                        }
                                        auswahl = 1;
                                    }
                                    if (auswahl == 0) {
                                        String[] deck6C = new String[deck6.length + 1];
                                        for (int i = 0; i < deck6.length; i++) {
                                            deck6C[i] = deck6[i];
                                        }
                                        deck6C[deck6C.length - 1] = giveCards(1, 1)[0][0];
                                        deck6 = deck6C;
                                        break LOOP_1;
                                    }
                                    if (istLegbar(stapelCard, deck6[auswahl - 1])) {
                                        String[] deckC6 = new String[deck6.length - 1];
                                        int c = 0;
                                        for (int i = 0; i < deckC6.length; i++) {
                                            if (i == auswahl - 1) {
                                                c++;
                                            }
                                            deckC6[i] = deck6[c];
                                            c++;
                                        }
                                        if (deck6[auswahl - 1].equals("ss")) {
                                            int newColor = getNumb("Welche Farbe willst du?  \u001B[31m 1  \u001B[32m 2  \u001B[34m 3  \u001B[33m 4", 1, 4);
                                            switch (newColor) {
                                                case 1 -> {
                                                    stapelCard = "rs";
                                                }
                                                case 2 -> {
                                                    stapelCard = "gs";
                                                }
                                                case 3 -> {
                                                    stapelCard = "bs";
                                                }
                                                case 4 -> {
                                                    stapelCard = "ys";
                                                }
                                            }
                                            stapel[stapel.length - 1] = stapelCard;
                                            deck6 = deckC6;
                                            break LOOP_1;
                                        }
                                        stapelCard = deck6[auswahl - 1];
                                        stapel[stapel.length - 1] = stapelCard;
                                        deck6 = deckC6;
                                        break LOOP_1;
                                    }
                                }
                                if (deck6.length >= 30) {
                                    printSpieleende();
                                    int wahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                                    switch (wahl) {
                                        case 1 -> {
                                            continue LOOP_2;
                                        }
                                        case 2 -> {
                                            System.out.println("\u001B[0m");
                                            continue LOOP_0;
                                        }
                                    }
                                }

                                if (deck6.length == 0) {
                                    printGewinnscreen(6);
                                    int auswahl = getNumb("Wie willst du weiter vorgehen? ", 1, 2);
                                    switch (auswahl) {
                                        case 1 -> {
                                            continue LOOP_2;
                                        }
                                        case 2 -> {
                                            System.out.println("\u001B[0m");
                                            continue LOOP_0;
                                        }
                                    }
                                }
                                printSichtschutz();
                                getInput("");

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
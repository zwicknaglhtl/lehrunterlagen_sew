public class StringAndChars {






    public static void main(String[] args) {

        /* char */

        char c1 = 'A';
        char c2= 'B';

        char c3 = 'A' + 2;
        System.out.println(c3); //C

        char c4 = (char) (c1 + 2);  //+ returns an int
        System.out.println(c4); //C

        /* char & String */
        String s1 = "ABC, die Katze lief im Schnee.";
        char c5 = s1.charAt(0);
        System.out.println(c5); //A
        c5 = s1.charAt(s1.length()-1);
        System.out.println(c5); //.

        System.out.println(c4+c5); //+ adds to numbers
        System.out.println(""+c4+c5); //+ Concatenation of three Strings

        /* test if Letter */
        char letter ='Ä';   //try with 'Ä' too!
        char noLetter='.';

        if (letter>='A' && letter <='Z' || letter>='a' && letter <='z') {
            System.out.println(letter +" is a letter!");
        } else {
            System.out.println(letter +" is not a letter!");
        }

        //to it the right way.
        if (Character.isLetter(letter)) {
            System.out.println(letter +" is a letter!");
        } else {
            System.out.println(letter +" is not a letter!");
        }

        System.out.println("Digit? " + Character.isDigit(letter));
        System.out.println(Character.toUpperCase(letter));
        System.out.println(Character.toLowerCase(letter));


        s1 = "ABC ABC";
        System.out.println(s1.indexOf('C'));
        System.out.println(s1.indexOf('M'));
        System.out.println(s1.lastIndexOf('C'));
        System.out.println(s1.indexOf('C', 3)); //start search from index 3

    }
}

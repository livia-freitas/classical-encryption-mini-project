import java.io.PrintWriter;

public class CaesarCipher {
    /**
     * Provides methods to encode and decode a word by adding/subtracting a key to it.
     */

    /**
     * Prints out a string formatted as "n = (key) : (en/decoded word)" Input: an integer and a word
     * Output: Returns nothing. Prints string to the screen.
     */
    public static void printNewWord(int num, String newWord) {
        PrintWriter pen = new java.io.PrintWriter(System.out, true);
        pen.println("n = " + num + ": " + newWord);
    } // printNewWord(int, String)

    /**
     * Takes in a word, an index, a loop number, and a number (1 or 2) representing encode/decode.
     * Returns the cypher letter.
     */
    public static char getCypherLetter(String word, int index, int loopNum, int cypherType) {
        char letter = word.charAt(index);
        int numLetter = (int) letter;
        int numNewLetter = -1;
        int alphabetSize = 26;
        int alphabetUpperBound = 122;
        int alphabetLowerBound = 97;

        if (cypherType == 1) { // cypherType 1 is encode
            numNewLetter = numLetter + loopNum;
            if (numNewLetter > alphabetUpperBound) {
                numNewLetter -= alphabetSize;
            } // if
        } else if (cypherType == 2) { // cypherType 2 is decode
            numNewLetter = numLetter - loopNum;
            if (numNewLetter < alphabetLowerBound) {
                numNewLetter += alphabetSize;
            } // if
        } // else
        char cypherLetter = (char) numNewLetter;
        return cypherLetter;
    }// getCypherLetter

    /**
     * Displays all 26 possible ways of encoding a string. Input: A string. Output: Returns nothing.
     * Prints encryption results to the screen.
     */
    public static void encode(String word) throws Exception {
        int size = word.length();
        char[] letterArray = word.toCharArray();
        for (int n = 0; n < 26; n++) {
            for (int i = 0; i < size; i++) {
                char newLetter = getCypherLetter(word, i, n, 1);
                letterArray[i] = newLetter;
            } // for
            String encodedWord = new String(letterArray);
            printNewWord(n, encodedWord);
        } // for
    }// encode(String)

    /**
     * Displays all 26 possible ways of decoding a string. Input: A string. Output: Returns nothing.
     */
    public static void decode(String word) throws Exception {

        int size = word.length();
        char[] letterArray = word.toCharArray();
        for (int n = 0; n < 26; n++) {
            for (int i = 0; i < size; i++) {
                char newLetter = getCypherLetter(word, i, n, 2);
                letterArray[i] = newLetter;
            } // for
            String decodedWord = new String(letterArray);
            printNewWord(n, decodedWord);
        }
    }// decode(String)

    public static void main(String[] args) throws Exception {

        PrintWriter pen = new java.io.PrintWriter(System.out, true);

        if (args.length != 2) {
            System.err.println("There should be exactly two inputs. Please try");
            System.exit(0);
        } else if (args[0].equals("encode") == false && args[0].equals("decode") == false) {
            System.err.println(
                    "First argument should be: either encode and decode, second: a lowercase/no whitespace word.");
            System.exit(0);
        } // else if
        if (args[0].equals("encode")) {
            encode(args[1]);
        } else if (args[0].equals("decode")) {
            decode(args[1]);
        } // else if
    } // main(String[] args)
} // CaesarCipher

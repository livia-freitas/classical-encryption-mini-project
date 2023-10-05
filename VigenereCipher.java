import java.io.PrintWriter;

public class VigenereCipher {

    /**
     * Returns a new word (the size of the plain text word) made of the repeated keyword. Input: Two
     * strings, a plain text string and the word to be repeated. Output: A string.
     */
    public static String wordRepeat(String plainText, String keyword) {

        int keySize = keyword.length();
        int plainTextSize = plainText.length();
        char[] newWordArray = plainText.toCharArray(); // to get an array the size of the plaintext
                                                       // word
        for (int i = 0; i < plainTextSize; i++) {
            int modIndex = i % keySize;
            char currentLetter = keyword.charAt(modIndex);
            newWordArray[i] = currentLetter;
        } // for
        String newWord = new String(newWordArray);
        return newWord;
    }// for

    /**
     * Takes in a plain text word, a keyword, an index number, and a number (1 or 2) representing
     * encode/decode. Returns the cypher letter.
     */
    public static char getCypherLetter(String plainText, String keyword, int index,
            int cypherType) {

        char plainLetter = plainText.charAt(index);
        char keyLetter = keyword.charAt(index);
        int numPlainLetter = (int) plainLetter;
        int numKeyLetter = (int) keyLetter - 97;
        int numNewLetter = -1;
        int alphabetSize = 26;
        int alphabetUpperBound = 122;
        int alphabetLowerBound = 97;

        if (cypherType == 1) { // cypherType 1 is encode
            numNewLetter = numPlainLetter + numKeyLetter;
            if (numNewLetter > alphabetUpperBound) {
                numNewLetter -= alphabetSize;
            } // if
        } else if (cypherType == 2) { // cypherType 2 is decode
            numNewLetter = numPlainLetter - numKeyLetter;
            if (numNewLetter < alphabetLowerBound) {
                numNewLetter += alphabetSize;
            } // if
        } // else
        char cypherLetter = (char) numNewLetter;
        return cypherLetter;
    }// getCypherLetter

    /**
     * Shifts a word by adding the alphabetical value of each letter of a keyword. Input: Two
     * strings, a plain text string and the keyword. Output: Returns nothing. Prints encryption
     * results to the screen.
     */
    public static void encode(String plainText, String keyword) {
        keyword = wordRepeat(plainText, keyword);
        PrintWriter pen = new PrintWriter(System.out, true);
        int size = plainText.length();
        char[] cypherArray = plainText.toCharArray();

        if(keyword.equals("")) {
            pen.println(plainText);
        } else if (plainText.equals("")) {
            pen.println(keyword);
        } else {
            for (int i = 0; i < size; i++) {
                char newLetter = getCypherLetter(plainText, keyword, i, 1);
                cypherArray[i] = newLetter;
            } // for
            String encodedWord = new String(cypherArray);
            pen.println(encodedWord);
        }//else
    }// encode(String, String)

    /**
     * Shifts a word by subtracting the alphabetical value of each letter of a keyword. Input: Two
     * strings, a plain text string and the keyword. Output: Returns nothing. Prints encryption
     * results to the screen.
     */
    public static void decode(String plainText, String keyword) {

        keyword = wordRepeat(plainText, keyword);
        PrintWriter pen = new PrintWriter(System.out, true);
        int size = plainText.length();
        char[] cypherArray = plainText.toCharArray();

        for (int i = 0; i < size; i++) {
            char newLetter = getCypherLetter(plainText, keyword, i, 2);
            cypherArray[i] = newLetter;
        } // for
        String decodedWord = new String(cypherArray);
        pen.println(decodedWord);
    }// decode(String, String)

    public static void main(String[] args) {

        PrintWriter pen = new java.io.PrintWriter(System.out, true);

        String error_one =
                "First argument should be either encode and decode, and plaintext/keyword should be lowercase with no whitespaces.";
        String error_two =
                "There should be three inputs: encode/decode, a word to be processed, and a keyword";

        if (args.length != 3) {
            System.err.println(error_two); //!!!!!!!
            System.exit(0);
        } else if (args[0].equals("encode") == false && args[0].equals("decode") == false) {
            System.err.println(error_one);
            System.exit(0);
        } 


        if (args[0].equals("encode")) {
            encode(args[1], args[2]);
        } else if (args[0].equals("decode")) {
            decode(args[1], args[2]);
        } // else if

    }// main(String[])
}// VigenereCipher



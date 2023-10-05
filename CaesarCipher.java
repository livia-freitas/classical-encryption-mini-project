import java.io.PrintWriter;

public class CaesarCipher{
    /**
    * Provides methods to encode and decode a word by adding/subtracting a key to it.
    */
    
    /** 
     * Prints out a string formatted as "n = (key) : (en/decoded word)"
     * Input: an integer and a word
     * Output: Returns nothing. Prints string to the screen.
     */
    public static void printNewWord (int num, String newWord) {
        PrintWriter pen = new java.io.PrintWriter(System.out, true);
        pen.println("n = " + num + ": " + newWord);
    } //printNewWord(int, String)

    public static void getCypherLetter (String word, int index, int cypherType) {
         char letter = word.charAt(index);
         int numLetter = (int) letter;
         if (cypherType == 1) {
             int numNewLetter = (numLetter + n);
             if (numNewLetter > 122) {
                 numNewLetter -= 26;
             }//if
         } else if (cypherType == 2) {
             int numNewLetter = (numLetter - n);
             if (numNewLetter < 97){
                 numNewLetter += 26;
             }//if
         }//else
         char cypherLetter = (char) (numNewLetter);
         return cypherLetter;
    }//getCypherLetter

    
    
     /**
         * Displays all 26 possible ways of encoding a string.
         * Input: A string.
         * Output: Returns nothing. Prints encryption results to the screen.
         */
    public static void encode(String word) throws Exception {
        int size = word.length();
        char[] letterArray = word.toCharArray();
        for (int n = 0; n < 26; n++) {
            char newLetter = getCypherLetter(word, i, 1);     
            letterArray[i] = newLetter;
            }//for
            String encodedWord = new String (letterArray);
            printNewWord(n, encodedWord);
        }//for
    }//encode(String)


    /**
     * Displays all 26 possible ways of decoding a string.
     * Input: A string.
     * Output: Returns nothing. 
     */
    public static void decode(String word) throws Exception {
        
        int size = word.length();
        char[] letterArray = word.toCharArray();
        for (int n = 0; n < 26; n++) {
            for (int i = 0; i < size; i++) {
                char newLetter = getCypherLetter(word, i, 2);
                letterArray[i] = newLetter;
            }//for
            String decodedWord = new String (letterArray);
            printNewWord(n, decodedWord);
        }//for
    }//decode(String)

    
    public static void main(String[] args) throws Exception {

        PrintWriter pen = new java.io.PrintWriter(System.out, true);
        String error_one = "First argument should be: either encode and decode, second: a lowercase/no whitespace word";
        String error_two = "There should be two inputs";
        
        if (args[0].equals("encode") == false && args[0].equals("decode") == false){
            System.err.println(error_one);
            System.exit(0);
        } else if (args.length != 2) {
            System.err.println(error_two);
            System.exit(0);
        } //else if
        if(args[0].equals("encode")) {
            encode(args[1]);
        } else if(args[0].equals("decode")) {
            decode(args[1]);
        }//else if     
    } // main(String[] args)
} // CaesarCipher

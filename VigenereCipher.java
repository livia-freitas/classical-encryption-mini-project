import java.io.PrintWriter;

public class VigenereCipher{

  
    public static String wordRepeat(String plainText, String keyword){
    /**
    * Returns a new word (the size of the plain text word) made of the repeated keyword.
    * Input: Two strings, a plain text string and the word to be repeated.
    * Output: A string.
    */

        int keySize = keyword.length();
        int plainTextSize = plainText.length();
        char[] newWordArray = plainText.toCharArray(); //to get an array the size of the plaintext word
        for (int i = 0; i < plainTextSize; i++){
            int modIndex = i % keySize;
            char currentLetter = keyword.charAt(modIndex);
            newWordArray[i] = currentLetter;
        }//for
        String newWord = new String (newWordArray);
        return newWord;
    }//for

    
    public static void encode(String plainText, String keyword){
    /**
    * Shifts a word by adding the alphabetical value of each letter of a keyword.
    * Input: Two strings, a plain text string and the keyword.
    * Output: Returns nothing. Prints encryption results to the screen.
    */

        keyword = wordRepeat(plainText, keyword);
        PrintWriter pen = new PrintWriter(System.out, true);
        int size = plainText.length();
        char[] cypherArray = plainText.toCharArray();
        pen.println(keyword);
       
        
        for (int i = 0; i < size; i++){
            char plainLetter = plainText.charAt(i);
            char keyLetter = keyword.charAt(i);
            int numPlainLetter = (int) plainLetter;
            int numKeyLetter = (int) keyLetter - 97;
            int numNewLetter = (numPlainLetter + numKeyLetter);
            if (numNewLetter > 122){
                numNewLetter -= 26;
            }//if
            char newLetter = (char) (numNewLetter);
            cypherArray[i] = newLetter;
        }//for
        String encodedWord = new String (cypherArray);
        pen.println("cypher: " + encodedWord);
    }//encode(String, String)

     public static void decode(String plainText, String keyword){
    /**
    * Shifts a word by subtracting the alphabetical value of each letter of a keyword.
    * Input: Two strings, a plain text string and the keyword.
    * Output: Returns nothing. Prints encryption results to the screen.
    */

        keyword = wordRepeat(plainText, keyword);
        PrintWriter pen = new PrintWriter(System.out, true);
        int size = plainText.length();
        char[] cypherArray = plainText.toCharArray();

        for (int i = 0; i < size; i++){
            char plainLetter = plainText.charAt(i);
            char keyLetter = keyword.charAt(i);
            int numPlainLetter = (int) plainLetter;
            int numKeyLetter = (int) keyLetter - 97;
            int numNewLetter = (numPlainLetter - numKeyLetter);
            if (numNewLetter < 97){
                numNewLetter += 26;
            }//if
            
            char newLetter = (char) (numNewLetter);
            cypherArray[i] = newLetter;
        }//for
        String decodedWord = new String (cypherArray);
        pen.println("cypher: " + decodedWord);
     }//decode(String, String)
    
    public static void main(String[] args){

        PrintWriter pen = new java.io.PrintWriter(System.out, true);
        
        String error_one = "First argument should be either encode and decode, and plaintext/keyword should be lowercase with no whitespaces.";
        String error_two = "There should be three inputs: encode/decode, a word to be processed, and a keyword";

        
        if (args[0].equals("encode") == false && args[0].equals("decode") == false){
            System.err.println(error_one);
            System.exit(0);
        }else if (args.length != 3){
            System.err.println(error_two);
            System.exit(0);
        }//else if


        if(args[0].equals("encode")){
            encode(args[1], args[2]);
        } else if(args[0].equals("decode")){
            decode(args[1], args[2]);
        }//else if
   
    }//main(String[])
}//VigenereCipher
        


        
  

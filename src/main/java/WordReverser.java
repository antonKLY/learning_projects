public class WordReverser {

    public static String wordToReverse(String word){
        StringBuilder reversed = new StringBuilder();
        for (int i = word.length() - 1 ; i >= 0 ; i--) {
            reversed.append(word.charAt(i));
        }
        return reversed.toString();
    }
}

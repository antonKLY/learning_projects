public class ReverseLastWord {

    public  static String lastWordReverse (String userString){
        String[] list = userString.split(" ");
        String lastWord = list[list.length - 1];
        return userString.substring(0,userString.lastIndexOf(' ')) + " " + WordReverser.wordToReverse(lastWord);
    }
}

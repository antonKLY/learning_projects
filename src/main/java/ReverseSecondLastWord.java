public class ReverseSecondLastWord {

    public  static String secondWordReverse (String userString){
        String[] list = userString.split(" ");
        String lastWord = list[list.length - 2];
        return userString.substring(0,userString.lastIndexOf(lastWord))
                + WordReverser.wordToReverse(lastWord)
                + userString.substring(userString.lastIndexOf(" "));
    }

}

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringOperation {


    public  static String newLineEveryTime (String userString){
        String[] list = userString.split(" ");
        StringBuilder newString = new StringBuilder();
        for (String s : list) {
            newString.append(s).append("\n");
        }
        return newString.toString();
    }

    public static  String getCapitalLetter(String userString) {
        String[] list = userString.split(" ");
        StringBuilder newString = new StringBuilder();
        for (String s : list) {
            String format = Character.toUpperCase(s.charAt(0)) + s.substring(1) + " ";
            newString.append(format);
        }
        return newString.toString();
    }

    public static String getCamelString(String usersString){
        StringBuilder finalString = new StringBuilder();

        for (int i = 0; i < usersString.length(); i++) {
            char aChar = usersString.charAt(i);
            if (i%2 == 0){
                finalString.append(Character.toUpperCase(aChar));
            } else finalString.append(Character.toLowerCase(aChar));
        }
        return finalString.toString();
    }
}

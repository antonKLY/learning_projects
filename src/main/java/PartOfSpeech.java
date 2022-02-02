import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PartOfSpeech {

    public static List<Word> whichPartOfSpeech(String usersSentence) throws IOException {
        String[] words = usersSentence.replaceAll("[-,]","").trim().split(" "); //дописать другие знаки и избавиться от них. уровнять регистр
        ArrayList<Word> wordList = new ArrayList<Word>();
        for (String word : words) {
            String search = String.format("https://wordius.ru/часть-речи/%s/", word.trim());
            Document doc = Jsoup.connect(search).ignoreHttpErrors(true).get();
            Elements elements = doc.select("div.rule");
            String partOfSpeech = elements.text();
            wordList.add(new Word(word,partOfSpeech));
        }
        return wordList;
    }

}

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BreakingBadFunClub {

    public  void bestQuoteFromBreakingBad() throws IOException {
        String url = "https://www.breakingbadapi.com/api/quote/random";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            Document doc = Jsoup.connect(url).ignoreContentType(true).get();
            Elements element = doc.select("body");
            String bodyText = element.text();
            String quote = getQuoteFromSite(bodyText);
            System.out.println(i + 1 + "  -  " + quote);
            list.add(quote);
        }
        int quoteNumber = askAboutQuote();
        quoteAnswer(list.get(quoteNumber - 1));
        FileSaver fs = new FileSaver("quotes.txt");
        FileSaver fs2 = new FileSaver("quotes2.txt");
        fs2.saveQuotesToFile(list.get(quoteNumber - 1));

    }

    private  String getQuoteFromSite(String text){
        int beginIndex = text.indexOf("quote\":\"") + 8;
        int lastIndex = text.lastIndexOf("\",\"author");
        return text.substring(beginIndex,lastIndex);
    }

    public  int askAboutQuote(){
        System.out.println("\nПеред Вами 5 цитат из сериала \"Во все тяжкие\". Выберите ту, которая Вам нравится");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public  void quoteAnswer( String quote){
        System.out.println("Вы выбрали цитату: " + quote + "\nОна будет записана в файл");
    }

//    public  List<Quotes> getMyFavoriteQuotes() throws IOException {
//        File file = new File("quotes.txt");
//        FileReader fr = new FileReader(file);
//        BufferedReader reader = new BufferedReader(fr);
//        String line = reader.readLine();
//        ArrayList<Quotes> myQuotesList = new ArrayList<>();
//        while (line != null) {
//            myQuotesList.add(new Quotes(line));
//            line = reader.readLine();
//        }
//        return myQuotesList;
//    }
}

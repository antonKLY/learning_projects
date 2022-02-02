import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NasaPhoto {

    public static void main(String[] args) throws IOException, ParseException {
        NasaPhoto nasaPhoto = new NasaPhoto();

        String textAPI = nasaPhoto.getTextFromAPI("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

        String urlForPeriod = nasaPhoto.getURLForPeriod();
        System.out.println(urlForPeriod);

        ArrayList <String> list = nasaPhoto.getAllFromPeriod(nasaPhoto.getTextFromAPI(urlForPeriod));
        for (String s : list){
            System.out.println(s);
        }
        nasaPhoto.createHTMLPageWithExplanationsAndPhoto(list);
    }


    public String getTextFromAPI(String html) throws IOException {
        Document doc = Jsoup.connect(html).ignoreContentType(true).get();
        Elements element = doc.select("body");
        return element.text();
    }

    public String getExplanation(String apiText) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(apiText);
        return json.get("explanation").toString();
    }

    public String getPhotoAndVideoURL(String apiText) throws ParseException {
        Pattern pattern = Pattern.compile("hdurl");
        Matcher matcher = pattern.matcher(apiText);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(apiText);
        if (!matcher.find()){
            return json.get("url").toString();
        } else {
            return json.get("hdurl").toString();
        }
    }

    public String getDate(String apiText) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(apiText);
        return json.get("date").toString();
    }

    public String getURLForPeriod(){
        System.out.println("Введите начало периода в формате YYYY-MM-DD");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        System.out.println("Введите конец периода в формате YYYY-MM-DD");
        String end = scanner.nextLine();
        return String.format("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=%s&end_date=%s",start,end);

    }

    public ArrayList <String> getAllFromPeriod(String apiText) throws ParseException {

        ArrayList <String> listOfText = new ArrayList<>();
        ArrayList <String> listOfExplanationsAndUrlForPictures = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\{(.*?)}");
        Matcher matcher = pattern.matcher(apiText);


        while(matcher.find()){
            listOfText.add(matcher.group(0));
        }

        for (String s : listOfText) {
            listOfExplanationsAndUrlForPictures.add("Date:  " + getDate(s));
            listOfExplanationsAndUrlForPictures.add(getPhotoAndVideoURL(s));
            listOfExplanationsAndUrlForPictures.add(getExplanation(s));
        }

        return listOfExplanationsAndUrlForPictures;
    }

    public void createHTMLPageWithExplanationsAndPhoto( ArrayList<String> periodList) throws IOException {
        File file = new File("C:\\Users\\anton\\Desktop\\nasa_picture_of_the_day.html");
        FileWriter fileWriter = new FileWriter(file,true);
        boolean isCreated = file.createNewFile();

        for (String s: periodList){
            if (!s.startsWith("https://apod")){
                fileWriter.write("<p>" + s + "</p>");
            } else {
                fileWriter.write("<img src=\"" + s + "\" height=”100px” width=”100px” >" );
            }
        }
        fileWriter.close();
    }

}

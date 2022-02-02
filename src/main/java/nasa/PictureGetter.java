package nasa;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class PictureGetter {

    public static void main(String[] args) throws IOException {
        PictureGetter pictureGetter = new PictureGetter();
//        String picAddress = pictureGetter.getPicAddressFromHtml("https://apod.nasa.gov/apod/astropix.html");
//        String htmlAddress = pictureGetter.generateHTMLPageFromImage(picAddress);
//        System.out.println(htmlAddress);


        String apiText = pictureGetter.getTextFromAPI("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        pictureGetter.getExplanation(apiText);
    }

    public String getTextFromAPI(String html) throws IOException {
        Document doc = Jsoup.connect(html).ignoreContentType(true).get();
        Elements element = doc.select("body");
        return element.text();
    }

    public void getExplanation(String textFromAPI) {

//        JSONObject obj = new JSONObject(textFromAPI);
//        String n = obj.getString("name");
//        int a = obj.getInt("age");
//        System.out.println(n + " " + a);  // prints "Alice 20"
    }

    public String generateHTMLPageFromImage(String imageName){
        return String.format("https://apod.nasa.gov/apod/%s",imageName);
    }



    public void getPicturesWithExplanation(String url){

    }
}

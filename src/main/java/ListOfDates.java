import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfDates {

    public static List<DayCourse> getListOfValuesByURL(String url) throws IOException {
        List<DayCourse> dayCourses = new ArrayList<DayCourse>();
        Document doc = Jsoup.connect(url).get();
        Elements elementsWithValue = doc.select("Value");
        Elements elementsWithDate = doc.select("Record");

        for (int i = 0; i < elementsWithValue.size(); i++) {
            String date = elementsWithDate.get(i).attr("Date");
            double course = Double.parseDouble(elementsWithValue.get(i).text().replaceAll(",","."));
            dayCourses.add(new DayCourse(date,course));
        }
        return dayCourses;
    }

    public static List<DayCourse> usersPeriodCourse() throws IOException {
        String startDate = CourseBot.askPeriodStart();
        String lastDate = CourseBot.askPeriodEnd();
        String finalURL
                = String.format("https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=%s&date_req2=%s&VAL_NM_RQ=R01235",startDate,lastDate);
        return getListOfValuesByURL(finalURL);
    }

    public static List<DayCourse> courseForLastNDays(int daysCount) throws IOException {
        String today = DateInRightFormat.getTodaysDate();
        String minusNDays = DateInRightFormat.getMinusNDays(daysCount);
        String finalURL
                = String.format("https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=%s&date_req2=%s&VAL_NM_RQ=R01235",minusNDays,today);
        System.out.println("Ссылка на источник:   " + finalURL);
        return getListOfValuesByURL(finalURL);

    }

}

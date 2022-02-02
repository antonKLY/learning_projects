import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class CourseDownloader {


    public List<DayCourse> getListOfCourses (Document doc){
        List<DayCourse> dayCourses = new ArrayList<DayCourse>();
        Elements elementsWithValue = doc.select("Value");
        Elements elementsWithDate = doc.select("Record");

        for (int i = 0; i < elementsWithValue.size(); i++) {
            String date = elementsWithDate.get(i).attr("Date");
            double course = Double.parseDouble(elementsWithValue.get(i).text().replaceAll(",","."));
            dayCourses.add(new DayCourse(date,course));
        }
        return dayCourses;
    }
}

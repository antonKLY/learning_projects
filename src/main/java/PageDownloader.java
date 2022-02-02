import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class PageDownloader {

    public Document getListOfCourses (String url) throws IOException {
        return Jsoup.connect(url).get();
    }




    //класс получает на вход Document, должен вернуть List<DayCourse>
    //cоздать класс  CourseDownloader возвращающий List курсов валют
    // . Его поля - дата с , дата по, код валюты
    //отдельный класс который находит наименьший и наибольшее значение за период

    //отдельнй класс возвращает самые большие скачки курса за период (DynamicsFounder) - возвращает List <CourseJump>
    //отд-й класс CourseJump: дата, дата перед скачком (dayCourseBefore(after) - переменные) новый Enum (UP/DOWN)
    // отдельный класс - выводит все скачки в консоль (DynamicPrinter)
    // отдельный класс по каждому из скачков выводит случайную новость на дату скачка(отдельный класс)
}

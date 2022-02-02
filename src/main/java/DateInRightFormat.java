import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateInRightFormat {

    public static String getTodaysDate (){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public static String getMinusNDays (int daysCount){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.minusDays(daysCount).format(formatter);
    }
}

import java.util.List;

public class Conclusion {

    public static void conclusion (String upOrDown, int periodInDays, double percentOfChange, List<DayCourse> listOfValues, int i){
       if (upOrDown.equals("up")){
           System.out.println("За последние " + periodInDays + " дней скачок ВВЕРХ больше чем на " + percentOfChange
                   + "%\nзарегестрирован в промежутке:\n" + listOfValues.get(i).getDay() + "\t-\t" + listOfValues.get(i).getCourse()
                   + "\n" + listOfValues.get(i + 1).getDay() + "\t-\t" + listOfValues.get(i + 1).getCourse() + "\n");
       } else {
           System.out.println("За последние " + periodInDays + " дней скачок ВНИЗ больше чем на " + percentOfChange
                   + "%\nзарегестрирован в промежутке:\n" + listOfValues.get(i).getDay() + "\t-\t" + listOfValues.get(i).getCourse()
                   + "\n" + listOfValues.get(i + 1).getDay() + "\t-\t" + listOfValues.get(i + 1).getCourse() + "\n");
       }

    }
}

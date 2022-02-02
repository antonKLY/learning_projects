import java.io.IOException;
import java.util.List;

public class CourseOperation {

    public static String buyOrNot (List<DayCourse> listOfValues){
        boolean doNotBuy = false;
        for (DayCourse aDouble : listOfValues) {
            if (aDouble.getCourse() > listOfValues.get(0).getCourse()) {
                doNotBuy = true;
                break;
            }
        }
        return doNotBuy ? "Покупать не следует" : "Нужно срочно покупать";
    }


    public static String highAndLowDirection (List<DayCourse> listOfValues){
        int stepUp = 0;
        int stepLow = 0;

        for (int j = 0; j < listOfValues.size() - 1; j++) {
            if (listOfValues.get(j).getCourse() < listOfValues.get(j + 1).getCourse()){
                stepUp++;
            }
            if (listOfValues.get(j).getCourse() > listOfValues.get(j + 1).getCourse()){
                stepLow++;
            }
        }

        return "За последние " + listOfValues.size() + " дней курс валют "
                + stepLow + " раз двигался вниз и " + stepUp + " раз вверх";
    }

    public static String maxAndMinValue (List<DayCourse> listOfValues){
        double resultMax = listOfValues.get(0).getCourse();
        double resultMin = listOfValues.get(0).getCourse();
        for (int i = 1; i < listOfValues.size(); i++) {
            resultMax = Math.max(resultMax, listOfValues.get(i).getCourse());
            resultMin = Math.min(resultMin, listOfValues.get(i).getCourse());
        }
        return "Самая высокая стоимость валюты за указанный период: " + resultMax
                + "\nСамая низкая стоимость валюты за указанный период: " + resultMin ;
    }

    public static void upLowForPeriod (int periodInDays, double percentOfChange ) throws IOException {
        String upOrDown = CourseBot.askUpOrDown();
        String today = DateInRightFormat.getTodaysDate();
        String dayMinusNDays = DateInRightFormat.getMinusNDays(periodInDays);
        String finalURL = String.format("https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=%s&date_req2=%s&VAL_NM_RQ=R01235",dayMinusNDays,today);
        List<DayCourse> listOfValues = ListOfDates.getListOfValuesByURL(finalURL);

        for (int i = 0; i < listOfValues.size(); i++) {
            if (i + 1 >= listOfValues.size()) break;
            if (listOfValues.get(i + 1).getCourse()  >= PercentsFormula.nPercentHigher(listOfValues,percentOfChange,i)
                    && upOrDown.equals("up")){
                Conclusion.conclusion(upOrDown,periodInDays,percentOfChange,listOfValues,i);
            }
            if (listOfValues.get(i + 1).getCourse()  <= PercentsFormula.nPercentLower(listOfValues,percentOfChange,i)
                    && upOrDown.equals("low")){
                Conclusion.conclusion(upOrDown,periodInDays,percentOfChange,listOfValues,i);
            }
        }
    }
}

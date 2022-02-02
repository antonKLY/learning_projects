import java.util.List;

public class PercentsFormula {

    public static double nPercentHigher (List <DayCourse> list, double n, int i){
        return list.get(i).getCourse() * (1 + ((float)n/100));
    }

    public static double nPercentLower (List <DayCourse> list, double n, int i){
        return list.get(i).getCourse() * (1 - ((float)n/100));
    }
}

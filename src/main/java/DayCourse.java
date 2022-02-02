import java.util.ArrayList;

public class DayCourse {

    String day;
    double course;
    static ArrayList <DayCourse> list = new ArrayList<DayCourse>();

    public DayCourse(String day, double course){
        this.course = course;
        this.day = day;
        list.add(this);
    }

    @Override
    public String toString() {
        return "Day: " + getDay() + " Course " + getCourse();
    }

    public String getDay() {
        return day;
    }

    public double getCourse() {
        return course;
    }


}

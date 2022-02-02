import java.util.ArrayList;
import java.util.List;

public class CourseJump {

    String dayToDay;
    String beforeDay;
    double courseChange;


    public void getJumpDiagram(List<DayCourse> dayCourse){
        for (int i = 1; i < dayCourse.size(); i++) {
            if (i + 1 == dayCourse.size()){
                break;
            }
            dayToDay = dayCourse.get(i + 1).getDay();
            beforeDay = dayCourse.get(i).getDay();
            courseChange =dayCourse.get(i).getCourse() - dayCourse.get(i + 1).getCourse();
            System.out.println(toString());
        }
    }

    @Override
    public String toString() {
        return "CourseJump{" +
                "dayToDay='" + dayToDay + '\'' +
                ", beforeDay='" + beforeDay + '\'' +
                ", courseChange=" + courseChange +
                '}';
    }
}

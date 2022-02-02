import java.util.List;

public class MaxAndMinValue {

    public DayCourse maxValueForPeriod(List<DayCourse> dayCourseList){
        double resultMax = dayCourseList.get(0).getCourse();
        for (int i = 1; i < dayCourseList.size(); i++) {
            resultMax = Math.max(resultMax, dayCourseList.get(i).getCourse());
        }

        for (DayCourse d : dayCourseList){
            if (d.getCourse() == resultMax){
                return d;
            }
        }
        return new DayCourse("0",0);
    }

    public DayCourse minValueForPeriod(List<DayCourse> dayCourseList){

        double resultMin = dayCourseList.get(0).getCourse();
        for (int i = 1; i < dayCourseList.size(); i++) {
            resultMin = Math.min(resultMin, dayCourseList.get(i).getCourse());
        }
        for (DayCourse d : dayCourseList){
            if (d.getCourse() == resultMin){
                return d;
            }
        }
        return new DayCourse("0",0);
    }

}

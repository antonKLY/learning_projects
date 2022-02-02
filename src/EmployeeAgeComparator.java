import java.util.Comparator;
public class EmployeeAgeComparator implements Comparator<OfficeEmployee> {

    @Override
    public int compare(OfficeEmployee o1, OfficeEmployee o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }
}

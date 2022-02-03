import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
        printEmployeeList(staff);
    }

    private static void printEmployeeList(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            System.out.printf("%02d - %s%n", i + 1, employees.get(i));
        }
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff,(e1,e2) -> {
        int salarySort = e1.getSalary().compareTo(e2.getSalary());
        if (salarySort == 0){
            return e1.getName().compareTo(e2.getName());
        }
        else return e1.getSalary().compareTo(e2.getSalary());
    });
    }
}

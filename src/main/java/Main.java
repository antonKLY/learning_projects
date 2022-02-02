import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        Employee oleg = new Employee("2",120000,new Date());
        System.out.println(oleg);
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
        System.out.println(staff);
        printEmployeeList(staff);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        LocalDateTime dateToCompare = LocalDateTime.now().withYear(year);
        return staff.stream()
                .filter(employee
                        -> convertToLocalDateTimeViaInstant(employee.getWorkStart()).getYear()
                        == dateToCompare.getYear())
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(IllegalStateException::new);
    }

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
    private static void printEmployeeList(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            System.out.printf("%03d - %s%n", i, employees.get(i));
        }
    }
}

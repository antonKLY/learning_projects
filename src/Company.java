import java.util.*;
public class Company {

    EmployeeAgeComparator ageComparator = new EmployeeAgeComparator();
    ArrayList<OfficeEmployee> employeeList = new ArrayList<>();

    public void hire(OfficeEmployee employee) {
        employee.recruit(this);
        employeeList.add(employee);
    }

    public void hireAll(List<OfficeEmployee> employees) {
        for (OfficeEmployee employee : employees) {
            hire(employee);
        }
    }

    public boolean fire(int countToFire) {
        if (countToFire >= 0 && countToFire <= employeeList.size()) {
            employeeList.subList(0, countToFire).clear();
            return true;
        } else {
            System.out.println("Неверное колличество сотрудников");
            return false;
        }
    }

    public int howManyWorkers() {
        return employeeList.size();
    }

    public void printEmployeeList(List<OfficeEmployee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            System.out.printf("%03d - %s%n", i, employees.get(i));
        }
    }

    public int getIncome() {
        int totalEarned = 0;
        for (Employee employee : employeeList) {
            if (employee instanceof EarnMoney) {
                totalEarned += ((EarnMoney) employee).getEarnedMoneyForCompany();
            }
        }
        return totalEarned;
    }

    public String getEmployeeSalaryList() {
        StringBuilder salaryList = new StringBuilder();
        for (OfficeEmployee employee : employeeList) {
            salaryList.append(employee.getMonthSalary()).append("\n");
        }
        return salaryList.toString();
    }

    public List<OfficeEmployee> getTopSalaryStaff(int count){
        return sortAndSliceEmployees(count,Comparator.naturalOrder());
    }

    public List<OfficeEmployee> getLowestSalaryStaff(int count) {
        return sortAndSliceEmployees(count,Comparator.reverseOrder());
    }

    public List<OfficeEmployee> getSortByAge (int count) {
        return sortAndSliceEmployees(count,ageComparator);
    }

    private boolean isCountCorrect(int count){
        if (count <= 0 || count > employeeList.size()) {
            System.out.println("Wrong count");
            return false;
        } return true;
    }

    private List<OfficeEmployee> sortAndSliceEmployees
            (int count, Comparator<OfficeEmployee> employeeComparator) {
        Collections.sort(employeeList,employeeComparator);
        if (!isCountCorrect(count)){
            return new ArrayList<>();
        }
        if (count > employeeList.size()) {
            return employeeList.subList(0, employeeList.size());
        }
        return employeeList.subList(0,count);
    }
}

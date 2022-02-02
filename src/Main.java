import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<OfficeEmployee> unemployedList = new ArrayList<>();

        Company company = new Company();


        for (;;) {
            Scanner scn = new Scanner(System.in);
            System.out.println("На какие должности необходимо нанять сотрудников?\n" +
                    " 0. Сотрудники не требуются\n 1. Oператор\n 2. Менеджер\n 3. Топ менеджер");
            int employeeType = scn.nextInt();
            if (employeeType == 0) {
                System.out.println("Завершение поиска сотрудников");
                break;
            }
            if (employeeType == 1) {
                System.out.println("Сколько операторов нанять?");
                int howManyEmp = scn.nextInt();
                for (int i = 0; i < howManyEmp; i++) {
                    unemployedList.add(new Operator());
                }
            }
            if (employeeType == 2) {
                System.out.println("Сколько менеджеров нанять?");
                int howManyEmp = scn.nextInt();
                for (int i = 0; i < howManyEmp; i++) {
                    unemployedList.add(new Manager());
                }
            }
            if (employeeType == 3) {
                System.out.println("Сколько топ менеджеров нанять?");
                int howManyEmp = scn.nextInt();
                for (int i = 0; i < howManyEmp; i++) {
                    unemployedList.add(new TopManager());
                }
            }
        }

        company.hireAll(unemployedList);
        System.out.println("Список зарплат сотрудников:\n" + company.getEmployeeSalaryList());

        System.out.println("\nСписок высоких зп:");
        company.printEmployeeList(company.getTopSalaryStaff(30));

        System.out.println("\nСписок низких зп:");
        company.printEmployeeList(company.getLowestSalaryStaff(30));

        company.fire(135);

        System.out.println("\nСписок высоких зп:");
        company.printEmployeeList(company.getTopSalaryStaff(30));

        System.out.println("\nСписок низких зп:");
        company.printEmployeeList(company.getLowestSalaryStaff(30));

        System.out.println("\nСортировка сотрудников по возрасту:");
        company.printEmployeeList(company.getSortByAge(50));

        System.out.println("Количество сотрудников в компании: " + company.howManyWorkers());
        System.out.println("Доход компании:\n" + company.getIncome());

    }
}

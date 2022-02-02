import java.util.Scanner;

public class CourseBot {

    public static String askUpOrDown(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас интересует движение курса ВВЕРХ или ВНИЗ (введите: up/low )");
        return scanner.nextLine();
    }

    public static String askPeriodStart(){
        System.out.println("Введите начало периода в формате 15/11/2021");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String askPeriodEnd(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите конец периода в формате 08/12/2021");
        return scanner.nextLine();
    }

}

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        long folderSize;

            for (; ; ) {
                System.out.println("Введите путь к папке или файлу:");
                userInput = scanner.nextLine();
                System.out.println("Размер папки " + userInput + ":");
                folderSize = FileUtils.calculateFolderSize(userInput);
                if (folderSize <= 100000) {
                    System.out.println(folderSize / 1024 + " Kb\n");
                }
                if (folderSize >= 100000 && folderSize <= 10000000) {
                    System.out.printf("%.2f", folderSize / 1024.0);
                    System.out.println(" Mb\n");
                }
                if (folderSize >= 10000000) {
                    System.out.printf("%.2f", folderSize / 1024.0 / 1024.0 / 1024.0);
                    System.out.println(" Gb\n");
                }
            }
        } catch (IOException ex){
            System.err.println(ex.toString());
        }
    }
}
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File source, destination;
        String sourceUserFolder, destinationUserFolder;

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(FileUtils.folderSize("C:\\Users\\anton\\Desktop\\1"));
        } catch (IOException e){
            e.printStackTrace();
        }


        for (;;) {
            System.out.println("Введите путь к папке для клонирования:");
            sourceUserFolder = scanner.nextLine();
            source = new File(sourceUserFolder);
            if (source.exists()) {
                System.out.println("Введите путь к новой папке:");
                destinationUserFolder = scanner.nextLine();
                destination = new File(destinationUserFolder);
                if (destination.exists()) {
                    System.err.print("\nПапка УЖЕ существует!");
                    continue;
                }
            } else {
                System.err.print("\nПапки НЕ существует!");
                continue;
            }
            try {
                FileUtils.copyFolder(sourceUserFolder, destinationUserFolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

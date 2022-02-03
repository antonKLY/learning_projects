import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {

        Files.walk(Paths.get(sourceDirectory))
                .forEach(source -> {
                    Path destination = Paths.get(destinationDirectory,source.toString().substring(sourceDirectory.length()));
                    try {
                        Files.copy(source, destination);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static List <Long> folderSize (String folder) throws IOException {
        List <Long> size = new ArrayList<>();

        Files.walk(Paths.get(folder)).forEach(file -> {
            File fl = new File(file.toString());
            size.add(fl.length());
        });
       
        return size;
    }
}

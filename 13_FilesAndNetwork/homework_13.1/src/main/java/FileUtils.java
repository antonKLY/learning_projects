import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public static long calculateFolderSize(String path) throws IOException {
        long userFolder = 0;
            Path userPath = Paths.get(path);

            List<Path> pathsToFiles;

            try (Stream<Path> walk = Files.walk(userPath)) {
                pathsToFiles = walk.filter(Files::isRegularFile)
                        .collect(Collectors.toList());
            }

            for (Path pathsToFile : pathsToFiles) {
                File x = new File(pathsToFile.toString());
                userFolder += x.length();
            }
            return userFolder;
    }
}
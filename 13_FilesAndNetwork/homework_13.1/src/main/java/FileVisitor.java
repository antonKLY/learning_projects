import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

class MyFileVisitor extends SimpleFileVisitor<Path>{

    public FileVisitResult checkingFiles(Path filePath) {

        File newFile = new File(filePath.toString());
        for (File s : newFile.listFiles()){
            System.out.println(s.length()/1024.0/1024.0 + " Мбайт");
        }

        return null;
    }
}

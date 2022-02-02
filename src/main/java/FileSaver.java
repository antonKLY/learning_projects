import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

    private String fileName;

    public FileSaver(String fileName){
        this.fileName = fileName;
    }

    public void saveQuotesToFile(String quote) throws IOException {
        File fileWithQuotes = new File(this.fileName);
        FileWriter fileWriter = new FileWriter(fileWithQuotes,true);
        if (fileWithQuotes.length() == 0){
            fileWriter.write(quote);
        } else fileWriter.write( "\n" + quote);
        fileWriter.close();
        System.out.println("Цитата добавлена.");
    }

}

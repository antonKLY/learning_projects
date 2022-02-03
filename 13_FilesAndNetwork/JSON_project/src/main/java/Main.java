import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JSONObject totalLineObj = new JSONObject();
        JSONArray lineArr = new JSONArray();
        JSONObject stationObj = new JSONObject();
        JSONObject totalStationObj = new JSONObject();



        try {
            String mainPageHtmlCode = parseFile("data/main_page.html");
            Document doc = Jsoup.parse(mainPageHtmlCode);
            //Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            Elements lines = doc.select("span.js-metro-line");
            Elements stations = doc.select("div.js-metro-stations");
            String [] stationName = stations.text().split(" 1\\. ");
            ArrayList <String> lineNumberForStation = new ArrayList<>();
            List<Connection> connectionList;
            List<List<Connection>> allStationsWithLine = new ArrayList<>();

            for (Element elem : stations) {
                String onLineNumber = elem.attr("data-line");
                lineNumberForStation.add(onLineNumber);
            }

            for (int i = 0; i < lineNumberForStation.size(); i++) {
                String[] tempString = stationName[i].split("[0-9]+\\.");
                JSONArray stationArr = new JSONArray();
                connectionList = new ArrayList<>();
                for (String s : tempString) {
                    if (s.equals("")){
                        continue;
                    }
                    stationArr.add(s.trim());
                    Connection connection = new Connection(s.trim(),lineNumberForStation.get(i));
                    connectionList.add(connection);
                }

                allStationsWithLine.add(connectionList);
                stationObj.put(lineNumberForStation.get(i),stationArr);
            }
            totalStationObj.put("Станции",stationObj);
            System.out.println(allStationsWithLine);

            for (Element el : lines) {
                String lineName = el.text();
                String lineNumber = el.attr("data-line");
                JSONObject lineNumbersAndNames = new JSONObject();
                lineNumbersAndNames.put("Номер", lineNumber);
                lineNumbersAndNames.put("Название",lineName);
                lineArr.add(lineNumbersAndNames);
            }
            totalLineObj.put("Линии",lineArr);

            String lineFileName = "C:\\Users\\anton\\Desktop\\Skillbox\\java_basics\\13_FilesAndNetwork\\JSON_project\\json_data\\lines.json";
            String stationsFileName = "C:\\Users\\anton\\Desktop\\Skillbox\\java_basics\\13_FilesAndNetwork\\JSON_project\\json_data\\stations.json";


            try (FileWriter file
                         = new FileWriter(lineFileName)) {
                file.write(totalLineObj.toJSONString());
              }

            try (FileWriter file
                         = new FileWriter(stationsFileName)) {
                file.write(totalStationObj.toJSONString());
              }

            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());
            JSONObject stationsObject = (JSONObject) jsonData.get("Станции");

            stationsObject.keySet().stream().sorted(Comparator.comparingInt(s -> Integer.parseInt(((String)s)
                    .replaceAll("[^\\d]", "")))).forEach(lineNumberObject -> {
                JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
                int stationsCount = stationsArray.size();
                System.out.println("На линии № " + lineNumberObject + "\t - \t" + stationsCount + " станции(й)");
            });

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
    public static String parseFile(String path){
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\anton\\Desktop\\Skillbox\\java_basics\\13_FilesAndNetwork\\JSON_project\\json_data\\stations.json"));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
class Connection {

    private String station;
    private String line;

    public Connection(String station, String line){
        this.station = station;
        this.line = line;
    }

    public String getStation() {
        return station;
    }

    public String getLine() {
        return line;
    }

    @Override
    public String toString() {
        return "{station=\"" + station + '\"' +
                ", line=\"" + line + "\"}";
    }
}

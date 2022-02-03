import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        String htmlPage = parseFile("data/new_code.html");
        Document connectionDOC = Jsoup.parse(htmlPage);
        Element tableWithAllLines = connectionDOC.select("div[class=t-text-simple]").last();
        Elements everyLine = tableWithAllLines.select("p > a.js-metrostation");
        Elements lines = tableWithAllLines.select("span.js-metro-line");

        Set<Station> stationsSet = new TreeSet<>();
        List<Set<Station>> transferHub = new LinkedList<>();
        Station station;

        List <String> lineNumbersList = lines.stream().map(elem -> elem.attr("data-line")).collect(Collectors.toList());
        List<Integer> stationNumbersList = new ArrayList<>();
        int arrayToBeNotEmpty = 1;
        stationNumbersList.add(arrayToBeNotEmpty);
        stationNumbersList.add(arrayToBeNotEmpty);
        int tempInt = 0;

        for (Element element : everyLine){
            String stationNumber = element.child(0).text().replace('.',' ').trim();
            int number = Integer.parseInt(stationNumber);
            stationNumbersList.add(number);

            if (stationNumbersList.get(stationNumbersList.size() - 2) > number){
                tempInt++;
            }

            if (element.childrenSize() <= 2){
                continue;
            }
            String mainStationLineNumber = lineNumbersList.get(tempInt);
            String mainStationName = element.child(1).text();

            if (!isConnectionExist(mainStationName,mainStationLineNumber,transferHub)){
                station = new Station(mainStationName,mainStationLineNumber);
                stationsSet.add(station);
            }

            for (int i = 2; i < element.childrenSize(); i++){
                String lineToCrossNumber = element.child(i).attr("class").substring(element.child(i).attr("class").lastIndexOf('-') + 1);
                String stationToCrossName = element.child(i).attr("title").substring(element.child(i).attr("title").indexOf('«') + 1,element.child(i).attr("title").lastIndexOf('»'));

                if (!isConnectionExist(stationToCrossName, lineToCrossNumber, transferHub)){
                    station = new Station(stationToCrossName,lineToCrossNumber);
                    stationsSet.add(station);
                }
                if (isConnectionExist(stationToCrossName, lineToCrossNumber, transferHub)
                        && !isConnectionExist(mainStationName,mainStationLineNumber,transferHub)){
                    station = new Station(stationToCrossName,lineToCrossNumber);
                    stationsSet.add(station);
                }
            }

            if (stationsSet.isEmpty()){
                continue;
            }
            transferHub.add(stationsSet);
            stationsSet = new HashSet<>();
        }
        int connectionsCount = transferHub.size();
        System.out.println("В московском метрополитене насчитывается " + connectionsCount + " пересадочных пунктов!");
        JSONObject object = parseToJSONConnections(transferHub);
        System.out.println(object);
        }

    public static JSONObject parseToJSONConnections (List<Set<Station>> connectionsList){
        JSONObject jobj ;
        JSONArray jsonArray = new JSONArray();
        JSONArray totalJsonArray = new JSONArray();
        JSONObject connections = new JSONObject();

        for (Set<Station> set : connectionsList){
            for (Station s : set){
                jobj = new JSONObject();
                jobj.put("station",s.getStation());
                jobj.put("line",s.getLine());
                jsonArray.add(jobj);
            }
            totalJsonArray.add(jsonArray);
            jsonArray = new JSONArray();
        }
        connections.put("connections",totalJsonArray);
        return connections;

    }

    public static JSONObject convertStationToJSONObject (Station station){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("station",station.getStation());
        jsonObject.put("line", station.getLine());
        return jsonObject;
    }

    public static boolean isConnectionExist(String station, String line, List<Set<Station>> list) {
        return list.stream().anyMatch(set -> set.stream().anyMatch(s -> s.getStation().equals(station) && s.getLine().equals(line)));
    }

    public static String parseFile(String path)  {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        //return builder.toString();
        throw new NullPointerException();
    }
}

class Station {
    private String station;
    private String line;

    int a = 1;
    long b = 2;
    double c = 4.5;
    char d = 'd';

    public Station(String station, String line){
        this.station = station;
        this.line = line;
    }

    public String getStation() {
        return station;
    }

    public String getLine() {
        return line;
    }

//    @Override
//    public String toString() {
//        return "station=\"" + station + '\"' +
//                ", line=\"" + line + '\"';
//    }
}

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Map<Station, Set<Station>> map = new HashMap<Station, Set<Station>>();
        Set<Station> stationSet1 = new HashSet<Station>();
        Set<Station> stationSet2 = new HashSet<Station>();
        Set<Station> stationSet = new HashSet<Station>();


        stationSet.add(new Station("Красная","1"));
        stationSet.add(new Station("Синяя","2"));
        stationSet.add(new Station("Желтая","3"));

        stationSet1.add(new Station("Черная","4"));
        stationSet1.add(new Station("Оранжевая","5"));
        stationSet1.add(new Station("Зелёная","6"));


        stationSet2.add(new Station("Арбузная","7"));
        stationSet2.add(new Station("Морковная","8"));
        stationSet2.add(new Station("Яблочная","9"));

        Station station1 = new Station("Парк Победы","2");
        Station station2 = new Station("Улица 1905","4");
        Station station3 = new Station("Площадт революции","5");

//        map.put(station1,stationSet);
        map.put(station2,stationSet1);
        map.put(station3,stationSet2);

        Station chekStation = new Station("Улица 1905","4");

        if (isConnectionExist("Улица 1905","4",map)){
            System.out.println("Connect exist");
        } else System.out.println("NOT exist");




//        for (Set<Station> set : connections){
//            for (Station s : set){
//                jobj.put("station",s.getStation());
//                jobj.put("line",s.getLine());
//                jobj = new JSONObject();
//                jsonArray.add(jobj);
//            }
//        }




   }
    public static boolean isConnectionExist(String station, String line, Map<Station,Set<Station>> map){
        boolean isConnectionExistInKey = true;
        boolean isConnectionExistInValue = true;
        for (Map.Entry<Station, Set<Station>> s : map.entrySet()){
            Station key = s.getKey();
            Set<Station> value = s.getValue();
            for (Station stat : value){
                boolean connectionInKey = key.getStation().equals(station) && key.getLine().equals(line);
                boolean connectionInValue = stat.getStation().equals(station) && stat.getLine().equals(line);
                if (!connectionInKey){
                    isConnectionExistInKey = false;
                } else continue;
                if (!connectionInValue){
                    isConnectionExistInValue = false;
                } else continue;
            }
        }
        return 
    }
}

class Station {

    public String getStation() {
        return station;
    }

    private String station;
    private String line;

    public String getLine() {
        return line;
    }

    public Station(String station, String line){
        this.station = station;
        this.line = line;
    }

    @Override
    public String toString() {
        return "station=\"" + station + '\"' +
                ", line=\"" + line + '\"';
    }
}

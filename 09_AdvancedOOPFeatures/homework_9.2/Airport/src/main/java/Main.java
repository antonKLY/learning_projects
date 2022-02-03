import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        final int hours = 2;
        Date nowPlus2Hours = convertToDateViaInstant(LocalDateTime.now().plusHours(hours));

        return airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(List::stream)
                .filter(flight -> flight.getDate().before(nowPlus2Hours))
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());
    }

    private static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }

}
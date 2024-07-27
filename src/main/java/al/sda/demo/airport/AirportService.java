package al.sda.demo.airport;

import java.util.List;

public interface AirportService {
    Airport saveAirport(Airport airport);
    Airport updateAirport(Long id, Airport airport);
    void deleteAirport(Long id);
    Airport getAirportById(Long id);
    List<Airport> getAllAirports();
}

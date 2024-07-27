package al.sda.demo.airport;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport airport) {
        // Retrieve the existing airport entity by its id from the repository
        Airport existingAirport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found"));
        existingAirport.setName(airport.getName());
        existingAirport.setDesignatedCity(airport.getDesignatedCity());

        return airportRepository.save(existingAirport);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found"));
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
}

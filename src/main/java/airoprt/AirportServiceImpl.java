package airoprt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Long id, Airport airport) {
        // Retrieve the existing airport entity by its id from the repository
        Airport existingAirport = airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found"));

        // Update the properties of the existing airport entity with the new values
//        existingAirport.setName(airport.getName());
//        existingAirport.setDesignatedCity(airport.getDesignatedCity());

        return airportRepository.save(existingAirport);
    }


    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

    @Override
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Airport not found"));
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
}
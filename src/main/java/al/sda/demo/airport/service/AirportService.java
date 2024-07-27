package al.sda.demo.airport.service;

import al.sda.demo.airport.mapper.AirportMapper;
import al.sda.demo.airport.model.Airport;
import al.sda.demo.airport.model.AirportDto;
import al.sda.demo.airport.repository.AirportRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    private static final String AIRPORT_NOT_FOUND = "Airport not found";
    private final AirportRepository repository;
    
    public AirportService(AirportRepository airportRepository) {
        this.repository = airportRepository;
    }
    
    public Long saveAirport(AirportDto airport) {
        if (repository.findByNameOrCode(airport.getName(), airport.getCode())
                    .isPresent()) {
            throw new EntityExistsException("An airport with the same name or code already exists");
        }
        
        Airport entity = AirportMapper.toEntity(airport);
        return repository.save(entity).getId();
    }
    
    public void updateAirport(Long id, AirportDto airport) {
        // Retrieve the existing airport entity by its id from the repository
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException();
            
        }
        airport.setId(id);
        // Update the existing airport entity with the new values
        repository.save(AirportMapper.toEntity(airport));
    }
    
    public void deleteAirport(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(AIRPORT_NOT_FOUND);
        }
        repository.deleteById(id);
    }
    
    public AirportDto getAirportById(Long id) {
        Airport existing = repository.findById(id)
                       .orElseThrow(() -> new EntityNotFoundException(AIRPORT_NOT_FOUND));
        return AirportMapper.toDto(existing);
    }
    
    public List<AirportDto> getList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable).getContent()
                       .stream()
                       .map(AirportMapper::toDto)
                       .toList();
    }
}

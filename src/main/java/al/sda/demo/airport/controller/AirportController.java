package al.sda.demo.airport.controller;

import al.sda.demo.airport.model.AirportDto;
import al.sda.demo.airport.service.AirportService;
import al.sda.demo.util.RestUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private final AirportService airportService;
    
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AirportDto> getAirportById(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.getAirportById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<AirportDto>> getList(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(airportService.getList(page, size));
    }
    
    @PostMapping
    public ResponseEntity<Void> saveAirport(AirportDto airport) {
        Long id = airportService.saveAirport(airport);
        URI location = RestUtil.locationBuilder(id.toString());
       
        return ResponseEntity.created(location)
                        .build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAirport(@PathVariable Long id, AirportDto airport) {
        airportService.updateAirport(id, airport);
        return ResponseEntity.noContent()
                        .build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent()
                        .build();
    }
}

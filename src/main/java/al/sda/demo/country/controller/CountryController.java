package al.sda.demo.country.controller;

import al.sda.demo.country.model.CountryDto;
import al.sda.demo.country.service.CountryService;
import al.sda.demo.util.RestUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
public class CountryController {
    
    private final CountryService countryService;
    
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    
    @GetMapping
    public ResponseEntity<List<CountryDto>> getCountryList(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) {
        List<CountryDto> resultSet = countryService.getCountryList(page, size)
                             .stream()
                             .map(c -> new CountryDto(c.getId(), c.getName(), c.getContinent()))
                             .collect(Collectors.toList());
        return ResponseEntity.ok(resultSet);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getCountryById(@RequestParam Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }
    
    @PostMapping
    public ResponseEntity<Void> createCountry(@RequestBody CountryDto countryDto) {
        Long id = countryService.createCountry(countryDto);
       
        URI location = RestUtil.locationBuilder(id.toString());
        return ResponseEntity.created(location)
                       .build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCountry(@RequestParam Long id, @RequestBody CountryDto countryDto) {
        countryService.updateCountry(id, countryDto);
        return ResponseEntity.noContent()
                       .build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@RequestParam Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent()
                       .build();
    }
    
}

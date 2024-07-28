package al.sda.demo.city.controller;

import al.sda.demo.city.mapper.CityMapper;
import al.sda.demo.city.model.City;
import al.sda.demo.city.model.CityDto;
import al.sda.demo.city.service.CityService;
import al.sda.demo.country.model.CountryDto;
import al.sda.demo.country.service.CountryService;
import al.sda.demo.util.RestUtil;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")

public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getCountryList(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size) {
        List<CityDto> resultSet = cityService.getCityList(page, size);
        return ResponseEntity.ok(resultSet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCityById(@RequestParam Long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCity(@RequestBody CityDto cityDto) {
        Long id = cityService.createCity(cityDto);

        URI location = RestUtil.locationBuilder(id.toString());
        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCity(@RequestParam Long id, @RequestBody CityDto cityDto) {
        cityService.updateCity(id, cityDto);
        return ResponseEntity.noContent()
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@RequestParam Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent()
                .build();
    }
    
}

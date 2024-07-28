package al.sda.demo.hotel.controller;

import al.sda.demo.hotel.model.HotelDto;
import al.sda.demo.hotel.service.HotelService;
import al.sda.demo.hotel.model.HotelDto;
import al.sda.demo.util.RestUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.getName;


@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getCountryList(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        List<HotelDto> resultSet = hotelService.getHotelList(page, size);
        return ResponseEntity.ok(resultSet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@RequestParam Long id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createHotel(@RequestBody HotelDto hotelDto) {
        Long id = hotelService.createHotel(hotelDto);

        URI location = RestUtil.locationBuilder(id.toString());
        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateHotel(@PathVariable Long id, @RequestBody HotelDto hotelDto) {
        hotelService.updateHotel(id, hotelDto);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@RequestParam Long id) {
        hotelService.delete(id);
        return ResponseEntity.noContent()
                .build();
    }
}


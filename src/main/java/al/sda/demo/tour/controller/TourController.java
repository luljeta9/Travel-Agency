package al.sda.demo.tour.controller;


import al.sda.demo.tour.model.Tour;
import al.sda.demo.tour.model.TourDto;
import al.sda.demo.tour.service.TourService;
import al.sda.demo.util.RestUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tours")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourDto> getTourById(@PathVariable Long id) {
        return ResponseEntity.ok(tourService.getTourById(id));
    }

    @GetMapping
    public ResponseEntity<List<TourDto>> getList(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(tourService.getList(page, size));
    }

    @PostMapping
    public ResponseEntity<Void> saveTour(TourDto tour) {
        Long id = tourService.saveTour(tour);
        URI location = RestUtil.locationBuilder(id.toString());

        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTour(@PathVariable Long id, TourDto tour) {
        tourService.updateTour(id, tour);
        return ResponseEntity.noContent()
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
        return ResponseEntity.noContent()
                .build();
    }
}

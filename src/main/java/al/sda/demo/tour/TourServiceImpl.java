package al.sda.demo.tour;

import al.sda.demo.tour.Tour;
import al.sda.demo.tour.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour updateTour(Long id, Tour tour) {
        Tour existingTour = tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));
        // Implement your update logic here
        // For example:
        // existingTour.setFromCity(tour.getFromCity());
        // existingTour.setFromAirport(tour.getFromAirport());
        // ... (set other fields)
        return tourRepository.save(existingTour);
    }

    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    public Tour getTourById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }
}

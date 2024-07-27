package al.sda.demo.tour;

import al.sda.demo.tour.Tour;

import java.util.List;

public interface TourService {
    Tour createTour(Tour tour);
    Tour saveTour(Tour tour);
    Tour updateTour(Long id, Tour tour);
    void deleteTour(Long id);
    Tour getTourById(Long id);
    List<Tour> getAllTours();
}


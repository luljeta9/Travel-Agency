package tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TourServiceImpl implements TourService {

    @Autowired
    private  TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    /**
     * @param tour
     * @return
     */
    @Override
    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    /**
     * @param id
     * @param tour
     * @return
     */
    @Override
    public Tour updateTour(Long id, Tour tour) {
        return null;
    }

//    @Override
//    public Tour updateTour(Long id, Tour tour) {
//
//
//        Tour existingTour = tourRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Tour not found"));
//        existingTour.setFromCity(tour.getFromCity());
//        existingTour.setFromAirport(tour.getFromAirport());
//        existingTour.setToCity(tour.getToCity());
//        existingTour.setToHotel(tour.getToHotel());
//        existingTour.setToAirport(tour.getToAirport());
//        existingTour.setDepartureDate(tour.getDepartureDate());
//        existingTour.setReturnDate(tour.getReturnDate());
//        existingTour.setNumberOfDays(tour.getNumberOfDays());
//        existingTour.setBoardBasisType(tour.getBoardBasisType());
//        existingTour.setPriceAdult(tour.getPriceAdult());
//        existingTour.setPriceChild(tour.getPriceChild());
//        existingTour.setPromoted(tour.isPromoted());
//        existingTour.setNumberOfAdultSeats(tour.getNumberOfAdultSeats());
//        existingTour.setNumberOfChildPlaces(tour.getNumberOfChildPlaces());
//        return tourRepository.save(existingTour);
//    }

    @Override
    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    @Override
    public Tour getTourById(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour not found"));
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }
}


package al.sda.demo.tour.service;

import al.sda.demo.tour.mapper.TourMapper;
import al.sda.demo.tour.model.Tour;
import al.sda.demo.tour.model.TourDto;
import al.sda.demo.tour.repository.TourRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    private static final String TOUR_NOT_FOUND = "Tour not found";
    private final TourRepository repository;
    public TourService(TourRepository tourRepository){this.repository = tourRepository; }
    public Long saveTour(TourDto tour){
        if (repository.findById(tour.getId())
        .isPresent()){
            throw new EntityExistsException("A tour with the same ID already exists");
        }
        Tour entity = TourMapper.toEntity(tour);
        return repository.save(entity).getId();
    }
    public void updateTour(Long id, TourDto tour){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException();
        }
        tour.setId(id);
        repository.save(TourMapper.toEntity(tour));
    }
    public void deleteTour(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(TOUR_NOT_FOUND);
        }
        repository.deleteById(id);
    }
    public TourDto getTourById(Long id) {
        Tour existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(TOUR_NOT_FOUND));
        return TourMapper.toDto(existing);
    }
    public List<TourDto> getList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable).getContent()
                .stream()
                .map(TourMapper::toDto)
                .toList();

    }
}

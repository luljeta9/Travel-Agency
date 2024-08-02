package al.sda.demo.tour.repository;

import al.sda.demo.airport.model.Airport;
import al.sda.demo.tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    Optional<Tour> findByName(String name);

}

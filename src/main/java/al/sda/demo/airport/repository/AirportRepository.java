package al.sda.demo.airport.repository;


import al.sda.demo.airport.model.Airport;
import al.sda.demo.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Optional<Airport> findByNameOrCode(String name, String code);

}

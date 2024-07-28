package al.sda.demo.hotel.repository;


import al.sda.demo.city.City;
import al.sda.demo.hotel.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    boolean existsByName(String name);
}



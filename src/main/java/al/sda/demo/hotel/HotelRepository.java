package al.sda.demo.hotel;


import al.sda.demo.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    // You can define custom query methods here if needed
    // For example, finding hotels by city
    List<Hotel> findByDesignatedCity(City city);
}


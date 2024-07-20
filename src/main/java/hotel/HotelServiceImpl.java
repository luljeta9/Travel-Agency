package hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {
        return null;
    }

//    @Override
//    public Hotel updateHotel(Long id, Hotel hotel) {
//        Hotel existingHotel = hotelRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Hotel not found"));
//        existingHotel.setName(hotel.getName());
//        existingHotel.setStandard(hotel.getStandard());
//        existingHotel.setDescription(hotel.getDescription());
//        existingHotel.setDesignatedCity(hotel.getDesignatedCity());
//        return hotelRepository.save(existingHotel);
//    }

    @Override
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}


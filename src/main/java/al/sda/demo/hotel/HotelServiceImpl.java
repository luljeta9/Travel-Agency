package al.sda.demo.hotel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        // existingsetName(getName());
        // existingsetStandard(getStandard());
        // existingsetDescription(getDescription());
        // existingsetDesignatedCity(getDesignatedCity());
        return hotelRepository.save(existingHotel);
    }


    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
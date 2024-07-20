package hotel;

import java.util.List;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);
    Hotel updateHotel(Long id, Hotel hotel);
    void deleteHotel(Long id);
    Hotel getHotelById(Long id);
    List<Hotel> getAllHotels();
}

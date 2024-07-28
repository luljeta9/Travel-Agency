package al.sda.demo.hotel.mapper;




import al.sda.demo.hotel.model.Hotel;
import al.sda.demo.hotel.model.HotelDto;

public class HotelMapper {

    public static HotelDto toDto(Hotel hotel) {
        HotelDto result = new HotelDto();
        result.setId(hotel.getId());
        result.setName(hotel.getName());
        result.setAddress(hotel.getAddress());
        result.setRating(hotel.getRating());
        return result;
    }

    public static Hotel toEntity(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDto.getId());
        hotel.setName(hotelDto.getName());
        hotel.setAddress(hotelDto.getAddress());
        hotel.setRating(hotelDto.getRating());
        return hotel;
    }
}

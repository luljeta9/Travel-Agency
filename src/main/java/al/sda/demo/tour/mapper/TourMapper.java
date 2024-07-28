package al.sda.demo.tour.mapper;

import al.sda.demo.tour.model.Tour;
import al.sda.demo.tour.model.TourDto;
import al.sda.demo.city.mapper.CityMapper;
import al.sda.demo.tour.model.Tour;
import al.sda.demo.tour.model.TourDto;

public class TourMapper {
    public static TourDto toDto(Tour tour) {
        TourDto tourDto = new TourDto();
        tourDto.setId(tour.getId());
        tourDto.setFromCity(tour.getFromCity());
        tourDto.setFromAirport(tour.getFromAirport());
        tourDto.setToHotel(tour.getToHotel());
        tourDto.setToAirport(tour.getToAirport());
        tourDto.setDepartureDate(tour.getDepartureDate());
        tourDto.setNumberOfDays(tour.getNumberOfDays());
        tourDto.setBoardBasisType(tour.getBoardBasisType());
        tourDto.setPriceAdult(tour.getPriceAdult());
        tourDto.setPriceChild(tour.getPriceChild());
        tourDto.setPromoted(tour.isPromoted());
        tourDto.setNumberOfAdultSeats(tour.getNumberOfAdultSeats());
        tourDto.setNumberOfChildPlaces(tour.getNumberOfChildPlaces());
        return tourDto;
    }

    public static Tour toEntity(TourDto tourDto) {
        Tour tour = new Tour();
        tour.setId(TourDto.getId());
        tour.setFromCity(TourDto.getFromCity());
        tour.setFromAirport(TourDto.getFromAirport());
        tour.setToHotel(TourDto.getToHotel());
        tour.setToAirport(TourDto.getToAirport());
        tour.setDepartureDate(TourDto.getDepartureDate());
        tour.setNumberOfDays(TourDto.getNumberOfDays());
        tour.setBoardBasisType(TourDto.getBoardBasisType());
        tour.setPriceAdult(TourDto.getPriceAdult());
        tour.setPriceChild(TourDto.getPriceChild());
        tour.setPromoted(TourDto.isPromoted());
        tour.setNumberOfAdultSeats(TourDto.getNumberOfAdultSeats());
        tour.setNumberOfChildPlaces(TourDto.getNumberOfChildPlaces());
        return tour;
    }

}

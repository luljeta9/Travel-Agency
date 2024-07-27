package al.sda.demo.airport.mapper;

import al.sda.demo.airport.model.Airport;
import al.sda.demo.airport.model.AirportDto;
import al.sda.demo.city.mapper.CityMapper;

public class AirportMapper {
    public static AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId());
        airportDto.setName(airport.getName());
        airportDto.setCode(airport.getCode());
        airportDto.setDesignatedCity(CityMapper.toDto(airport.getDesignatedCity()));
        return airportDto;
    }

    public static Airport toEntity(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setId(airportDto.getId());
        airport.setName(airportDto.getName());
        airport.setCode(airportDto.getCode());
        airport.setDesignatedCity(CityMapper.toEntity(airportDto.getDesignatedCity()));
        return airport;
    }
    
}

package al.sda.demo.city.mapper;

import al.sda.demo.city.City;
import al.sda.demo.city.CityDto;
import al.sda.demo.country.mapper.CountryMapper;

public class CityMapper {
    
    public static CityDto toDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setCountry(CountryMapper.toDto(city.getCountry()));
        return cityDto;
    }
    
    public static City toEntity(CityDto cityDto) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setName(cityDto.getName());
        city.setCountry(CountryMapper.toEntity(cityDto.getCountry()));
        return city;
    }
}

package al.sda.demo.country.mapper;

import al.sda.demo.country.model.Country;
import al.sda.demo.country.model.CountryDto;

public class CountryMapper {
    
    public static CountryDto toDto(Country country) {
        return new CountryDto(country.getId(), country.getName(), country.getContinent());
    }
    
    public static Country toEntity(CountryDto countryDto) {
        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());
        return country;
    }
}

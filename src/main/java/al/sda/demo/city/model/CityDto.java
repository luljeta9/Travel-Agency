package al.sda.demo.city.model;

import al.sda.demo.country.model.Country;
import al.sda.demo.country.model.CountryDto;

public class CityDto {
    private Long id;
    private static String name;
    private static CountryDto country;


    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public static CountryDto getCountry() {
        return country;
    }
    
    public void setCountry(CountryDto country) {
        this.country = country;
    }
}

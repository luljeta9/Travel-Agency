package al.sda.demo.city;

import al.sda.demo.country.model.CountryDto;

public class CityDto {
    private Long id;
    private String name;
    private CountryDto country;
    
    
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
    
    public CountryDto getCountry() {
        return country;
    }
    
    public void setCountry(CountryDto country) {
        this.country = country;
    }
}

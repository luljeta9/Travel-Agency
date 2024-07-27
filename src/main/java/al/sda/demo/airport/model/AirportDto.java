package al.sda.demo.airport.model;

import al.sda.demo.city.CityDto;

public class AirportDto {
    private Long id;
    private String name;
    private String code;
    private CityDto designatedCity;
    
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
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public CityDto getDesignatedCity() {
        return designatedCity;
    }
    
    public void setDesignatedCity(CityDto designatedCity) {
        this.designatedCity = designatedCity;
    }
}

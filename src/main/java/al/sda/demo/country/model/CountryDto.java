package al.sda.demo.country.model;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;

public class CountryDto {
    private Long id;
    private String name;
    private Continent continent;
    
    public CountryDto(Long id, String name, Continent continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }
    
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
    
    public Continent getContinent() {
        return continent;
    }
    
    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}

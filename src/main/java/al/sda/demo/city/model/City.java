package al.sda.demo.city.model;

import al.sda.demo.country.model.Continent;
import al.sda.demo.country.model.Country;
import jakarta.persistence.*;

import java.util.Set;

@Entity

@Table(name = "cities")

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(nullable = false)
    // Foreign key relationship

    @ManyToOne
    private Country country;


    @JoinColumn(name = "city")
    private Set<Country> cities;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public Country getCountry() {
        return country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
}

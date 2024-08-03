package al.sda.demo.country.model;


import al.sda.demo.city.model.City;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    
    @Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(nullable = false)
    private Continent continent; // Foreign key relationship

    @OneToMany(mappedBy = "country")

    private Set<City> cities;
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

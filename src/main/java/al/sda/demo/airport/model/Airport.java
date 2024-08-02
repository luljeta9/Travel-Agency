package al.sda.demo.airport.model;

import al.sda.demo.city.model.City;
import jakarta.persistence.*;

@Entity
@Table(name = "airports")

public class
Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // unique identifier for the airport

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City designatedCity; // foreign key reference to the City entity
    
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
    
    public City getDesignatedCity() {
        return designatedCity;
    }
    
    public void setDesignatedCity(City designatedCity) {
        this.designatedCity = designatedCity;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
}

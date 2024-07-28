package al.sda.demo.hotel.model;

import al.sda.demo.city.model.City;
import jakarta.persistence.*;


@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City designatedCity;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public City getDesignatedCity() {
        return designatedCity;
    }

    public void setDesignatedCity(City designatedCity) {
        this.designatedCity = designatedCity;
    }
}

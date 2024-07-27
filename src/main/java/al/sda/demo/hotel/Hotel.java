package al.sda.demo.hotel;

import al.sda.demo.city.City;
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
    private int standard;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City designatedCity;

    // Getters and setters, constructors
}

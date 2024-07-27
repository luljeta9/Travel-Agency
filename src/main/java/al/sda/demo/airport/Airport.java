package al.sda.demo.airport;

import al.sda.demo.city.City;
import jakarta.persistence.*;

@Entity
@Table(name = "airports")

public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; // unique identifier for the airport

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City designatedCity; // foreign key reference to the City entity

    // Csg
}

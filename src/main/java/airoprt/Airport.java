package airoprt;

import jakarta.persistence.*;
import nationality.City;
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

    // Constructors, getters, and setters
}

package tour;

import airoprt.Airport;
import hotel.Hotel;
import jakarta.persistence.*;
import nationality.City;

import java.time.LocalDate;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_city_id")
    private  String fromCity;

    @ManyToOne
    @JoinColumn(name = "from_airport_id")
    private String fromAirport;

    @ManyToOne
    @JoinColumn(name = "to_city_id")
    private String toCity;

    @ManyToOne
    @JoinColumn(name = "to_hotel_id")
    private String toHotel;

    @ManyToOne
    @JoinColumn(name = "to_airport_id")
    private String toAirport;

    @Column(nullable = false)
    private LocalDate departureDate;

    @Column(nullable = false)
    private LocalDate returnDate;

    @Column(nullable = false)
    private int numberOfDays;

    @Enumerated(EnumType.STRING)
    private BoardBasisType boardBasisType;

    @Column(nullable = false)
    private double priceAdult;

    @Column(nullable = false)
    private double priceChild;

    @Column(nullable = false)
    private boolean promoted;

    @Column(nullable = false)
    private int numberOfAdultSeats;

    @Column(nullable = false)
    private int numberOfChildPlaces;

    // Getters and setters, constructors
}


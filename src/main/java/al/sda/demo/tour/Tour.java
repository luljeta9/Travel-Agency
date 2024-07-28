package al.sda.demo.tour;

import al.sda.demo.airport.model.Airport;
import al.sda.demo.city.City;
import al.sda.demo.hotel.model.Hotel;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_city_id")
    private  City fromCity;

    @ManyToOne
    @JoinColumn(name = "from_airport_id")
    private Airport fromAirport;

    @ManyToOne
    @JoinColumn(name = "to_city_id")
    private City toCity;

    @ManyToOne
    @JoinColumn(name = "to_hotel_id")
    private Hotel toHotel;

    @ManyToOne
    @JoinColumn(name = "to_airport_id")
    private Airport toAirport;

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


}


package al.sda.demo.tour.model;

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

    public Long getId() {
        return null;
    }

    public String getFromCity() {
        return null;
    }

    public String getFromAirport() {
        return null;
    }

    public String getToHotel() {
        return null;
    }

    public String getToAirport() {
        return null;
    }

    public LocalDate getDepartureDate() {
        return null;
    }

    public int getNumberOfDays() {
        return 0;
    }

    public BoardBasisType getBoardBasisType() {
        return null;
    }

    public double getPriceAdult() {
        return 0;
    }

    public double getPriceChild() {
        return 0;
    }

    public boolean isPromoted() {
        return false;
    }

    public int getNumberOfAdultSeats() {
        return 0;
    }

    public int getNumberOfChildPlaces() {
        return 0;
    }

    public void setId(Long id) {
    }

    public void setFromCity(String fromCity) {
    }

    public void setFromAirport(String fromAirport) {
    }

    public void setToHotel(String toHotel) {
    }

    public void setToAirport(String toAirport) {
    }

    public void setDepartureDate(LocalDate departureDate) {
    }

    public void setNumberOfDays(int numberOfDays) {
    }

    public void setBoardBasisType(BoardBasisType boardBasisType) {
    }

    public void setPriceAdult(double priceAdult) {
    }

    public void setPriceChild(double priceChild) {
    }

    public void setPromoted(boolean promoted) {
    }

    public void setNumberOfAdultSeats(int numberOfAdultSeats) {
    }

    public void setNumberOfChildPlaces(int numberOfChildPlaces) {
    }
}


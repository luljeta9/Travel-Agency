package al.sda.demo.tour.model;

import java.time.LocalDate;

public class TourDto {
    private static Long id;
    private static String fromCity;
    private static String fromAirport;
    private static String toHotel;
    private static String toAirport;
    private static LocalDate departureDate;
    private static int numberOfDays;
    private static BoardBasisType boardBasisType;
    private static double priceAdult;
    private static double priceChild;
    private static boolean promoted;
    private static int numberOfAdultSeats;
    private static int numberOfChildPlaces;


    public static Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public static String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public static String getToHotel() {
        return toHotel;
    }

    public void setToHotel(String toHotel) {
        this.toHotel = toHotel;
    }

    public static String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public static LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public static int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public static BoardBasisType getBoardBasisType() {
        return boardBasisType;
    }

    public void setBoardBasisType(BoardBasisType boardBasisType) {
        this.boardBasisType = boardBasisType;
    }

    public static double getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(double priceAdult) {
        this.priceAdult = priceAdult;
    }

    public static double getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(double priceChild) {
        this.priceChild = priceChild;
    }

    public static boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public static int getNumberOfAdultSeats() {
        return numberOfAdultSeats;
    }

    public void setNumberOfAdultSeats(int numberOfAdultSeats) {
        this.numberOfAdultSeats = numberOfAdultSeats;
    }

    public static int getNumberOfChildPlaces() {
        return numberOfChildPlaces;
    }

    public void setNumberOfChildPlaces(int numberOfChildPlaces) {
        this.numberOfChildPlaces = numberOfChildPlaces;
    }


}




package TripPresenter;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class trippresenter {

    // Function to present promoted trips
    public void presentPromotedTrips(List<String> promotedTrips) {
        System.out.println("Promoted Trips:");
        for (String trip : promotedTrips) {
            System.out.println(trip);
        }
    }

    // Function to present upcoming tours globally
    public void presentUpcomingToursGlobally(List<String> upcomingTours) {
        System.out.println("Upcoming Tours (Globally):");
        for (String tour : upcomingTours) {
            System.out.println(tour);
        }
    }

    // Function to present upcoming trips divided into continents
    public void presentUpcomingTripsByContinent(List<String> upcomingTrips, String continent) {
        System.out.println("Upcoming Trips (Continent: " + continent + "):");
        for (String trip : upcomingTrips) {
            System.out.println(trip);
        }
    }

    // Function to present upcoming trips by country
    public void presentUpcomingTripsByCountry(List<String> upcomingTrips, String country) {
        System.out.println("Upcoming Trips (Country: " + country + "):");
        for (String trip : upcomingTrips) {
            System.out.println(trip);
        }
    }

    // Function to present recently purchased tours
    public void presentRecentlyPurchasedTours(List<String> purchasedTours) {
        System.out.println("Recently Purchased Tours:");
        for (String tour : purchasedTours) {
            System.out.println(tour);
        }
    }



    public static void main(String[] args) {
        trippresenter presenter = new trippresenter();

        // Example usage
        List<String> promotedTrips = new ArrayList<>();
        promotedTrips.add("Trip to Paris");
        promotedTrips.add("Trip to Tokyo");

        List<String> upcomingTours = new ArrayList<>();
        upcomingTours.add("Tour to London");
        upcomingTours.add("Tour to New York");

        List<String> upcomingTripsEurope = new ArrayList<>();
        upcomingTripsEurope.add("Trip to Berlin");
        upcomingTripsEurope.add("Trip to Madrid");

        List<String> upcomingTripsUSA = new ArrayList<>();
        upcomingTripsUSA.add("Trip to Los Angeles");
        upcomingTripsUSA.add("Trip to Miami");

        List<String> purchasedTours = new ArrayList<>();
        purchasedTours.add("Tour to Sydney");
        purchasedTours.add("Tour to Cape Town");

        presenter.presentPromotedTrips(promotedTrips);
        presenter.presentUpcomingToursGlobally(upcomingTours);
        presenter.presentUpcomingTripsByContinent(upcomingTripsEurope, "Europe");
        presenter.presentUpcomingTripsByCountry(upcomingTripsUSA, "USA");
        presenter.presentRecentlyPurchasedTours(purchasedTours);

    }
}

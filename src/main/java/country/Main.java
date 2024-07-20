package country;

import continent.Continent;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Continent asia = new Continent(1, "Asia");
        Continent europe = new Continent(2, "Europe");
        Continent america = new Continent(3, "America");

        CountryService countryService = new CountryServiceImpl();

        // Adding countries
        countryService.addCountry(new Country(1, "Japan", asia));
        countryService.addCountry(new Country(2, "China", asia));
        countryService.addCountry(new Country(3, "Germany", europe));
        countryService.addCountry(new Country(4, "France", europe));
        countryService.addCountry(new Country(5, "Italy", europe));
        countryService.addCountry(new Country(6, "Canada", america));


        // Retrieving all countries
        List<Country> allCountries = countryService.getAllCountries();
        System.out.println("All Countries:");
        for (Country country : allCountries) {
            System.out.println(country.getId() + ": " + country.getName() + " - " + country.getContinent().getName());
        }

        // Retrieving countries by continent
        List<Country> countriesInAsia = countryService.getCountriesByContinent(asia);
        System.out.println("\nCountries in Asia:");
        for (Country country : countriesInAsia) {
            System.out.println(country.getId() + ": " + country.getName());
        }

        // Deleting a country
        countryService.deleteCountry(2);

        // Updating a country
        Country updatedCountry = new Country(3, "Germany (updated)", europe);
        countryService.updateCountry(3, updatedCountry);

        // Retrieving a country by ID
        Country countryById = countryService.getCountryById(4);
        if (countryById != null) {
            System.out.println("\nCountry found by ID:");
            System.out.println(countryById.getId() + ": " + countryById.getName());
        } else {
            System.out.println("\nCountry not found.");
        }
    }
}

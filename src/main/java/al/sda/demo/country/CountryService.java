package country;

import continent.Continent;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();

    List<Country> getCountriesByContinent(Continent continent);

    Country getCountryById(int id);

    void addCountry(Country country);

    void updateCountry(int id, Country country);

    void deleteCountry(int id);
}


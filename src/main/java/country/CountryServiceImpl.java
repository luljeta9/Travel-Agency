package country;

import continent.Continent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountryServiceImpl implements CountryService {
    private List<Country> countries = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<Country> getAllCountries() {
        return countries;
    }

    @Override
    public List<Country> getCountriesByContinent(Continent continent) {
        return countries.stream()
                .filter(country -> country.getContinent().getId() == continent.getId())
                .collect(Collectors.toList());
    }

    @Override
    public Country getCountryById(int id) {
        for (Country country : countries) {
            if (country.getId() == id) {
                return country;
            }
        }
        return null;
    }

    @Override
    public void addCountry(Country country) {
        country.setId(nextId++);
        countries.add(country);
    }

    @Override
    public void updateCountry(int id, Country updatedCountry) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getId() == id) {
                countries.set(i, updatedCountry);
                return;
            }
        }
    }

    @Override
    public void deleteCountry(int id) {
        countries.removeIf(country -> country.getId() == id);
    }
}


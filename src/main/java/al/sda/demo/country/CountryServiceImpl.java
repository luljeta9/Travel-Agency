package al.sda.demo.country;

import al.sda.demo.continent.Continent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryServiceImpl implements CountryService {

    private List<Country> countries = new ArrayList<>();
    private int nextId = 1;

    public List<Country> getAllCountries() {
        return new ArrayList<>(countries); // Return a copy to prevent external modification
    }

    public List<Country> getCountriesByContinent(Continent continent) {
        return countries.stream()
                .filter(country -> country.getContinent().getId() == continent.getId())
                .collect(Collectors.toList());
    }

    public Country getCountryById(int id) {
       return countries.stream()
                .filter(country -> country.getId() == id)
                .findFirst().orElse(null);// Return null if not found
    }

    public void addCountry(Country country) {
        country.setId(nextId++);
        countries.add(country);
    }

    public void updateCountry(int id, Country updatedCountry) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getId() == id) {
                countries.set(i, updatedCountry);
                return;
            }
        }
        // Optionally throw an exception if country with given id not found
    }

    public void deleteCountry(int id) {
        countries.removeIf(country -> country.getId() == id);
    }
}

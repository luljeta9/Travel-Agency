package al.sda.demo.continent;

import java.util.ArrayList;
import java.util.List;

public class ContinentServiceImpl implements ContinentService {

    private List<Continent> continents = new ArrayList<Continent>();
    private int nextId = 1;

    public List<Continent> getAllContinents() {
        return continents;
    }

    public Continent getContinentById(int id) {
        for (Continent continent : continents) {
            if (continent.getId() == id) {
                return continent;
            }
        }
        return null;
    }

    public void addContinent(Continent continent) {
        continent.setId(nextId++);
        continents.add(continent);
    }

    public void updateContinent(int id, Continent updatedContinent) {
        for (int i = 0; i < continents.size(); i++) {
            if (continents.get(i).getId() == id) {
                continents.set(i, updatedContinent);
                return;
            }
        }
    }

    public void deleteContinent(int id) {
        continents.removeIf(continent -> continent.getId() == id);
    }
}

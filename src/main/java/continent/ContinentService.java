package continent;

import java.util.List;

public interface ContinentService {
    List<Continent> getAllContinents();

    Continent getContinentById(int id);

    void addContinent(Continent continent);

    void updateContinent(int id, Continent continent);

    void deleteContinent(int id);
}

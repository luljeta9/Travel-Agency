package continent;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContinentService continentService = new ContinentServiceImpl();

        // Adding continents
        continentService.addContinent(new Continent(1, "Asia"));
        continentService.addContinent(new Continent(2, "Europe"));

        // Retrieving all continents
        List<Continent> allContinents = continentService.getAllContinents();
        System.out.println("All Continents:");
        for (Continent continent : allContinents) {
            System.out.println(continent.getId() + ": " + continent.getName());
        }

        // Updating a continent
        Continent updatedContinent = new Continent(2, "Europe (updated)");
        continentService.updateContinent(2, updatedContinent);

        // Deleting a continent
        continentService.deleteContinent(1);

        // Retrieving a continent by ID
        Continent continentById = continentService.getContinentById(2);
        if (continentById != null) {
            System.out.println("Continent found by ID:");
            System.out.println(continentById.getId() + ": " + continentById.getName());
        } else {
            System.out.println("Continent not found.");
        }
    }
}


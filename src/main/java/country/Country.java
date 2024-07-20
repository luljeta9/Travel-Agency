package country;

import continent.Continent;

public class Country {
    private int id;
    private String name;
    private Continent continent; // Foreign key relationship

    // Constructors
    public Country(int id, String name, Continent continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}

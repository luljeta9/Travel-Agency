package al.sda.demo.country.model;

public enum Continent {
    AFRICA("Africa"),
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    OCEANIA("Australia"),
    SOUTH_AMERICA("South America");
    private final String name;
    
    Continent(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static Continent fromName(String name) {
        for (Continent continent : values()) {
            if (continent.name.equals(name)) {
                return continent;
            }
        }
        throw new IllegalArgumentException("No continent with name " + name);
    }
}

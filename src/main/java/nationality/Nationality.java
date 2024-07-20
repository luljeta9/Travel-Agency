package nationality;

public class Nationality {
    private Long id;  // Assuming an ID field
    private String name;

    // Constructors, getters, and setters
    public Nationality() {
    }

    public Nationality(String name) {
        this.name = name;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

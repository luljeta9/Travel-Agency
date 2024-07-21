package nationality;

import jakarta.persistence.*;
@Entity

@Table(name = "cities")

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;



    private Nationality nationality;  // Foreign key reference

    // Constructors, getters, and setters
    public City() {
    }

    public City(String name, Nationality nationality) {
        this.name = name;
        this.nationality = nationality;
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

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }





}

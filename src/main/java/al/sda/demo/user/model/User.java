package al.sda.demo.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)

    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)

    private LocalDate birthday;
    @Column(nullable = false)


    private String username;
    @Column(nullable = false)


    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    public User() {
        // Initialize with default values
        this.firstName = "";
        this.lastName = "";
        this.birthday = LocalDate.now(); // Set to current date by default
        this.username = "";
        this.password = "";
        this.email = "";
    }

    public User(Long id, String firstName, String lastName, LocalDate birthday, String username, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    @Column(nullable = false, unique = true)




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




//    private static final long serialVersionUID = 1L; // Unique identifier for serialization




    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public LocalDate getBirthday() {
        return birthday;
    }


    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    // Method to return a formatted string representation of the user

//    public String toString() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return "User [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday.format(formatter) + "]";
//    }




}


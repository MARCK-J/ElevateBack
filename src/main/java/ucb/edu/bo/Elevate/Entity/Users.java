package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users {

    /*
    -- Table: Users
    CREATE TABLE Users (
        user_id SERIAL PRIMARY KEY,
        first_name varchar(50)  NOT NULL,
        last_name varchar(50)  NOT NULL,
        email varchar(100)  NOT NULL,
        password varchar(100)  NOT NULL,
        role int  NOT NULL,
        Verification boolean  NOT NULL,
        date_join date  NOT NULL
    );
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private int role;

    @Column(name = "verification")
    private boolean verification;

    @Column(name = "date_join")
    private Date dateJoin;

    // Getters y Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public Date getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(Date dateJoin) {
        this.dateJoin = dateJoin;
    }

    // toString
    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", verification=" + verification +
                ", dateJoin=" + dateJoin +
                '}';
    }
}

package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class Users {

    /*
    -- Table: Users
    CREATE TABLE users (
        user_id int  NOT NULL,
        first_name varchar(50)  NOT NULL,
        last_name varchar(50)  NOT NULL,
        email varchar(100)  NOT NULL,
        password varchar(100)  NOT NULL,
        role int  NOT NULL,
        date_join date  NOT NULL,
        CONSTRAINT Users_pk PRIMARY KEY (user_id)
    );
     */

    @Id
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
                ", dateJoin=" + dateJoin +
                '}';
    }
}

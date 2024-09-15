package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "teacher")
public class Teacher {

    /*
    -- Table: Teacher
    CREATE TABLE teacher (
        user_id int  NOT NULL,
        enrollment_date date  NOT NULL,
        CONSTRAINT Teacher_pk PRIMARY KEY (user_id)
    );
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "enrollment_date")
    private Date enrollmentDate;

    // Getters y Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    // toString
    @Override
    public String toString() {
        return "Teacher{" +
                "userId=" + userId +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}


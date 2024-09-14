package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {

    /*
    -- Table: Student
    CREATE TABLE student (
        user_id int  NOT NULL,
        enrollment_date date  NOT NULL,
        CONSTRAINT Student_pk PRIMARY KEY (user_id)
    );
     */

    @Id
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
        return "Student{" +
                "userId=" + userId +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}


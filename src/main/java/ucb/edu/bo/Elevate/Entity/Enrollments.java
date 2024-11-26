package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "enrollments")
public class Enrollments {

    /*
    -- Table: Enrollments
    CREATE TABLE Enrollments (
        enrollment_id int  NOT NULL,
        enrollment_date timestamp  NOT NULL,
        Student_user_id int  NOT NULL,
        Courses_course_id int  NOT NULL,
        Completed boolean  NOT NULL,
        CONSTRAINT Enrollments_pk PRIMARY KEY (enrollment_id)
    );
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @Column(name = "enrollment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date enrollmentDate;

    @Column(name = "student_user_id", nullable = false)
    private Long studentUserId;

    @Column(name = "courses_course_id", nullable = false)
    private Long coursesCourseId;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    // Getters y Setters
    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Long getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(Long studentUserId) {
        this.studentUserId = studentUserId;
    }

    public Long getCoursesCourseId() {
        return coursesCourseId;
    }

    public void setCoursesCourseId(Long coursesCourseId) {
        this.coursesCourseId = coursesCourseId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // toString
    @Override
    public String toString() {
        return "Enrollments{" +
                "enrollmentId=" + enrollmentId +
                ", enrollmentDate=" + enrollmentDate +
                ", studentUserId=" + studentUserId +
                ", coursesCourseId=" + coursesCourseId +
                ", completed=" + completed +
                '}';
    }
}

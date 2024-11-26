package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "certification")
public class Certification {

    /*
    -- Table: Certification
    CREATE TABLE Certification (
        certification_id SERIAL PRIMARY KEY,
        student_user_id INT NOT NULL,
        course_id INT NOT NULL,
        issue_date TIMESTAMP NOT NULL,
        CONSTRAINT Certification_Student_fk FOREIGN KEY (student_user_id)
            REFERENCES Student (user_id),
        CONSTRAINT Certification_Courses_fk FOREIGN KEY (course_id)
            REFERENCES Courses (course_id)
    );
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certification_id")
    private Long certificationId;

    @Column(name = "student_user_id", nullable = false)
    private Long studentUserId;

    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "issue_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    // Getters and Setters
    public Long getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Long certificationId) {
        this.certificationId = certificationId;
    }

    public Long getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(Long studentUserId) {
        this.studentUserId = studentUserId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    // toString
    @Override
    public String toString() {
        return "Certification{" +
                "certificationId=" + certificationId +
                ", studentUserId=" + studentUserId +
                ", courseId=" + courseId +
                ", issueDate=" + issueDate +
                '}';
    }
}
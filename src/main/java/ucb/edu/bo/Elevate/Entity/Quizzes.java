package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quizzes")
public class Quizzes {

    /*    
    -- Table: Quizzes (quizzes o evaluaciones)
    CREATE TABLE Quizzes (
        quiz_id SERIAL PRIMARY KEY,
        title varchar(255) NOT NULL,
        description text NOT NULL,
        due_date date NOT NULL,
        lessons_id int NOT NULL,
        CONSTRAINT Quizzes_Lessons_fk FOREIGN KEY (lessons_id)
            REFERENCES Lessons (lessons_id)
    );*/
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Integer quizId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @Column(name = "lessons_id", nullable = false)
    private Integer lessonsId;

    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    // Getters y Setters
    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getLessonsId() {
        return lessonsId;
    }

    public void setLessonsId(Integer lessonsId) {
        this.lessonsId = lessonsId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    // toString
    @Override
    public String toString() {
        return "Quizzes{" +
                "quizId=" + quizId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", lessonsId=" + lessonsId +
                ", courseId=" + courseId +
                '}';
    }
}
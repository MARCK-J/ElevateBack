package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {

    /*
    -- Table: Courses
    CREATE TABLE Courses (
        course_id int  NOT NULL,
        title varchar(255)  NOT NULL,
        description text  NOT NULL,
        available boolean  NOT NULL,
        Teacher_user_id int  NOT NULL,
        Category_course_id int  NOT NULL,
        CONSTRAINT Courses_pk PRIMARY KEY (course_id)
    );
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "available", nullable = false)
    private boolean available;

    @Column(name = "teacher_user_id", nullable = false)
    private Long teacherUserId;

    @Column(name = "category_course_id", nullable = false)
    private Long categoryCourseId;

    // Getters y Setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getTeacherUserId() {
        return teacherUserId;
    }

    public void setTeacherUserId(Long teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public Long getCategoryCourseId() {
        return categoryCourseId;
    }

    public void setCategoryCourseId(Long categoryCourseId) {
        this.categoryCourseId = categoryCourseId;
    }

    // toString
    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", teacherUserId=" + teacherUserId +
                ", categoryCourseId=" + categoryCourseId +
                '}';
    }
}

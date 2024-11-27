package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorites {

    /*
    -- Table: favorites
    CREATE TABLE favorites (
        favorite_id SERIAL PRIMARY KEY,
        student_user_id BIGINT NOT NULL,
        course_id BIGINT NOT NULL,
        FOREIGN KEY (student_user_id) REFERENCES student(user_id),
        FOREIGN KEY (course_id) REFERENCES courses(course_id)
    );
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Long favoriteId;

    @Column(name = "student_user_id")
    private Long studentUserId;

    @Column(name = "course_id")
    private Long courseId;

    // Getters and Setters
    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
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

    @Override
    public String toString() {
        return "Favorites{" +
                "favoriteId=" + favoriteId +
                ", studentUserId=" + studentUserId +
                ", courseId=" + courseId +
                '}';
    }
}
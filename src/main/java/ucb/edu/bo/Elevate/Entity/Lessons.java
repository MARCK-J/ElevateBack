package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public class Lessons {

    /*
    -- Table: Lessons
    CREATE TABLE Lessons (
        lessons_id SERIAL  NOT NULL,
        course_id int  NOT NULL,
        title varchar(50)  NOT NULL,
        description varchar(255)  NOT NULL,
        duration varchar(25)  NOT NULL,
        content text  NOT NULL,
        video text  NOT NULL,
        "order" int  NOT NULL,
        complete boolean  NOT NULL,
        CONSTRAINT Lessons_pk PRIMARY KEY (lessons_id)
    );
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lessons_id")
    private Long lessonsId;

    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "video", nullable = false)
    private String video;

    @Column(name = "\"order\"", nullable = false)
    private int order;

    @Column(name = "complete", nullable = false)
    private boolean complete;

    // Getters y Setters
    public Long getLessonsId() {
        return lessonsId;
    }

    public void setLessonsId(Long lessonsId) {
        this.lessonsId = lessonsId;
    }

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    // toString
    @Override
    public String toString() {
        return "Lessons{" +
                "lessonsId=" + lessonsId +
                ", courseId=" + courseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", content='" + content + '\'' +
                ", video='" + video + '\'' +
                ", order=" + order +
                ", complete=" + complete +
                '}';
    }
}

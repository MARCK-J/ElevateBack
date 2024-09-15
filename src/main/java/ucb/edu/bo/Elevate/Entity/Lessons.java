package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public class Lessons {

    /*
    -- Table: Lessons
    CREATE TABLE Lessons (
        lessons_id int  NOT NULL,
        course_id int  NOT NULL,
        title varchar(255)  NOT NULL,
        content text  NOT NULL,
        archive xml  NOT NULL,
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

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "archive", nullable = false, columnDefinition = "xml")
    private String archive;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
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
                ", content='" + content + '\'' +
                ", archive='" + archive + '\'' +
                ", video='" + video + '\'' +
                ", order=" + order +
                ", complete=" + complete +
                '}';
    }
}

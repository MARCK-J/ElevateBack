package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long resultId;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "submission_date", nullable = false)
    private Date submissionDate;

    @Column(name = "quiz_id", nullable = false)
    private Long quizId;

    @Column(name = "student_user_id", nullable = false)
    private Long studentUserId;

    // Getters y Setters
    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(Long studentUserId) {
        this.studentUserId = studentUserId;
    }

    // toString
    @Override
    public String toString() {
        return "Results{" +
                "resultId=" + resultId +
                ", score=" + score +
                ", submissionDate=" + submissionDate +
                ", quizId=" + quizId +
                ", studentUserId=" + studentUserId +
                '}';
    }
}

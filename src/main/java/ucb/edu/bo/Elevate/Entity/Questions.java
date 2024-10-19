package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {

    /* 
        -- Table: Questions (preguntas del quiz)
        CREATE TABLE Questions (
            question_id SERIAL PRIMARY KEY,
            quiz_id int NOT NULL,
            content text NOT NULL,
            question_type varchar(50) NOT NULL, -- tipo de pregunta (e.g. multiple choice, true/false)
            CONSTRAINT Questions_Quizzes_fk FOREIGN KEY (quiz_id)
                REFERENCES Quizzes (quiz_id)
        );
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "quiz_id", nullable = false)
    private Long quizId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "question_type", nullable = false)
    private String questionType;

    // Getters y Setters
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    // toString
    @Override
    public String toString() {
        return "Questions{" +
                "questionId=" + questionId +
                ", quizId=" + quizId +
                ", content='" + content + '\'' +
                ", questionType='" + questionType + '\'' +
                '}';
    }
}

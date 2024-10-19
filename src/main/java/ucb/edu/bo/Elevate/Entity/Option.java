package ucb.edu.bo.Elevate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Option {

/* 
    -- Table: Options (opciones de preguntas, si es multiple choice)
        CREATE TABLE Options (
            option_id SERIAL PRIMARY KEY,
            question_id int NOT NULL,
            content text NOT NULL,
            is_correct boolean NOT NULL, -- si es la respuesta correcta o no
            CONSTRAINT Options_Questions_fk FOREIGN KEY (question_id)
                REFERENCES Questions (question_id)
        );
*/    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long optionId;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;

    // Getters y Setters
    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    // toString
    @Override
    public String toString() {
        return "Option{" +
                "optionId=" + optionId +
                ", questionId=" + questionId +
                ", content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}

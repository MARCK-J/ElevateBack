package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.Elevate.Entity.Questions;

import java.util.List;

public interface QuestionDAO extends JpaRepository<Questions, Integer> {
    List<Questions> findByQuizId(Integer quizId);
}

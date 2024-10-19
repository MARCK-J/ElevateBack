package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.Elevate.Entity.Quizzes;

import java.util.List;

public interface QuizDAO extends JpaRepository<Quizzes, Integer> {
    List<Quizzes> findByLessonsId(Integer lessonsId);
}

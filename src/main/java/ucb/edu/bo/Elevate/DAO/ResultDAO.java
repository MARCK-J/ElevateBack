package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.Elevate.Entity.Results;

import java.util.List;

public interface ResultDAO extends JpaRepository<Results, Integer> {
    List<Results> findByQuizId(Integer quizId);
    List<Results> findByStudentUserId(Integer studentUserId);
}
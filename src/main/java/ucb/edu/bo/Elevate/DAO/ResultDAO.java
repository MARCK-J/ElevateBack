package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.Elevate.Entity.Results;

import java.util.List;
import java.util.Optional;

public interface ResultDAO extends JpaRepository<Results, Integer> {
    List<Results> findByQuizId(Integer quizId);
    List<Results> findByStudentUserId(Integer studentUserId);
    Optional<Results> findByQuizIdAndStudentUserId(Long quizId, Long studentUserId);
}
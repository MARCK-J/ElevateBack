package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.Elevate.Entity.Option;

import java.util.List;

public interface OptionDAO extends JpaRepository<Option, Integer> {
    List<Option> findByQuestionId(Integer questionId);
}
package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import ucb.edu.bo.Elevate.Entity.Teacher;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {

    @Query(value = "SELECT * FROM teacher WHERE user_id = ?1", nativeQuery = true)
    List<Teacher> findTeacherByUserId(Long userId);
}

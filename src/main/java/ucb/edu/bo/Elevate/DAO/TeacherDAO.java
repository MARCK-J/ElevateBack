package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.Elevate.Entity.Teacher;

import java.util.List;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer> {

    @Query(value = "SELECT * FROM teacher WHERE user_id = ?1", nativeQuery = true)
    List<Teacher> findTeacherByUserId(Long userId);
}

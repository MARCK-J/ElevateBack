package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.Elevate.Entity.Student;

import java.util.List;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student WHERE user_id = ?1", nativeQuery = true)
    List<Student> findStudentByUserId(Long userId);
}

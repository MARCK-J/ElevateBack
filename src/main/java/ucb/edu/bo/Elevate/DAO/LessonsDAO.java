package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import ucb.edu.bo.Elevate.Entity.Lessons;

@Repository
public interface LessonsDAO extends JpaRepository<Lessons, Long> {

    @Query(value = "SELECT * FROM lessons WHERE course_id = ?1", nativeQuery = true)
    List<Lessons> findByCourseId(Long courseId);

    @Query(value = "SELECT * FROM lessons WHERE title = ?1", nativeQuery = true)
    List<Lessons> findByTitle(String title);

    @Query(value = "SELECT * FROM lessons WHERE complete = ?1", nativeQuery = true)
    List<Lessons> findByCompletionStatus(boolean complete);

    @Query(value = "SELECT * FROM lessons WHERE \"order\" = ?1", nativeQuery = true)
    List<Lessons> findByOrder(int order);

    @Query(value = "SELECT * FROM lessons WHERE course_id = ?1 ORDER BY \"order\"", nativeQuery = true)
    List<Lessons> findByCourseIdOrderByOrder(Long courseId);

    @Query(value = "SELECT * FROM lessons WHERE user_id = ?1 AND course_id = ?2 AND complete = true", nativeQuery = true)
    List<Lessons> findCompletedLessonsByUserIdAndCourseId(Long userId, Long courseId);
}

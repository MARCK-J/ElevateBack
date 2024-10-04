package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import ucb.edu.bo.Elevate.Entity.Courses;

@Repository
public interface CoursesDAO extends JpaRepository<Courses, Long> {

    @Query(value = "SELECT * FROM courses WHERE title = ?1", nativeQuery = true)
    List<Courses> findByTitle(String title);

    @Query(value = "SELECT * FROM courses WHERE teacher_user_id = ?1", nativeQuery = true)
    List<Courses> findByTeacherUserId(Long teacherUserId);

    @Query(value = "SELECT * FROM courses WHERE category_course_id = ?1", nativeQuery = true)
    List<Courses> findByCategoryCourseId(Long categoryCourseId);

    @Query(value = "SELECT * FROM courses WHERE available = ?1", nativeQuery = true)
    List<Courses> findByAvailability(boolean available);

    @Query(value = "SELECT course_id FROM courses ORDER BY course_id DESC LIMIT 1", nativeQuery = true)
    Long findLastCourseId();
}

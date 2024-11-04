package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ucb.edu.bo.Elevate.Entity.Courses;

import java.util.List;

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

    // query para obtener los cursos por duracion
    @Query(value = "SELECT * FROM courses WHERE duration = ?1", nativeQuery = true)
    List<Courses> findByDuration(String duration);

    // query para obtener los cursos por rating
    @Query(value = "SELECT * FROM courses WHERE rating = ?1", nativeQuery = true)
    List<Courses> findByRating(double rating);

    // query para obtener los cursos por userId
    @Query(value = "SELECT * FROM courses WHERE teacher_user_id = ?1", nativeQuery = true)
    List<Courses> findByTeacherUserId(Integer userId);

    @Query("SELECT c FROM Courses c WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    Page<Courses> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @Query("SELECT c FROM Courses c WHERE c.rating >= :rating")
    Page<Courses> findByRatingGreaterThanEqual(double rating, Pageable pageable);

    @Query("SELECT c FROM Courses c WHERE LOWER(c.duration) LIKE LOWER(CONCAT('%', :duration, '%'))")
    Page<Courses> findByDurationContainingIgnoreCase(String duration, Pageable pageable);
}

package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import ucb.edu.bo.Elevate.Entity.Enrollments;

@Repository
public interface EnrollmentsDAO extends JpaRepository<Enrollments, Long> {

    @Query(value = "SELECT * FROM enrollments WHERE student_user_id = ?1", nativeQuery = true)
    List<Enrollments> findByStudentUserId(Long studentUserId);

    @Query(value = "SELECT * FROM enrollments WHERE courses_course_id = ?1", nativeQuery = true)
    List<Enrollments> findByCoursesCourseId(Long coursesCourseId);

    @Query(value = "SELECT * FROM enrollments WHERE enrollment_date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Enrollments> findEnrollmentsByDateRange(Date startDate, Date endDate);
}

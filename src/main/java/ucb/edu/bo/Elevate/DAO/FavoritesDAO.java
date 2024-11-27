package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.Elevate.Entity.Favorites;

import java.util.List;
import java.util.Optional;

public interface FavoritesDAO extends JpaRepository<Favorites, Long> {
    List<Favorites> findByStudentUserId(Long studentUserId);
    Optional<Favorites> findByStudentUserIdAndCourseId(Long studentUserId, Long courseId);
}
package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.edu.bo.Elevate.Entity.Favorites;

import java.util.List;

public interface FavoritesDAO extends JpaRepository<Favorites, Long> {
    List<Favorites> findByStudentUserId(Long studentUserId);
}
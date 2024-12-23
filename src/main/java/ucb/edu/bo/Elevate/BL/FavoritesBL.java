package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.FavoritesDAO;
import ucb.edu.bo.Elevate.Entity.Favorites;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesBL {

    private final FavoritesDAO favoritesDao;

    @Autowired
    public FavoritesBL(FavoritesDAO favoritesDao) {
        this.favoritesDao = favoritesDao;
    }

    public ResponseDTO addFavorite(Long studentUserId, Long courseId) {
        Favorites favorite = new Favorites();
        favorite.setStudentUserId(studentUserId);
        favorite.setCourseId(courseId);
        favoritesDao.save(favorite);
        return new ResponseDTO("Favorite added successfully");
    }

    public ResponseDTO getFavoritesByStudentUserId(Long studentUserId) {
        List<Favorites> favorites = favoritesDao.findByStudentUserId(studentUserId);
        return new ResponseDTO(favorites);
    }

    public ResponseDTO deleteFavorite(Long studentUserId, Long courseId) {
        Optional<Favorites> favorite = favoritesDao.findByStudentUserIdAndCourseId(studentUserId, courseId);
        if (favorite.isPresent()) {
            favoritesDao.delete(favorite.get());
            return new ResponseDTO("Favorite deleted successfully");
        } else {
            return new ResponseDTO("Favorite not found");
        }
    }
}
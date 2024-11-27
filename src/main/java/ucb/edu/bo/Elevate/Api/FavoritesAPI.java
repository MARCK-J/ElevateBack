package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.FavoritesBL;
import ucb.edu.bo.Elevate.DTO.FavoritesDTO;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/favorites")
public class FavoritesAPI {

    private final FavoritesBL favoritesBl;

    @Autowired
    public FavoritesAPI(FavoritesBL favoritesBl) {
        this.favoritesBl = favoritesBl;
    }

    @PostMapping("/add")
    public ResponseDTO addFavorite(@RequestBody FavoritesDTO favoritesDTO) {
        return favoritesBl.addFavorite(favoritesDTO.getStudentUserId(), favoritesDTO.getCourseId());
    }

    @GetMapping("/student/{studentUserId}")
    public ResponseDTO getFavoritesByStudentUserId(@PathVariable Long studentUserId) {
        return favoritesBl.getFavoritesByStudentUserId(studentUserId);
    }

    @DeleteMapping("/delete")
    public ResponseDTO deleteFavorite(@RequestParam Long studentUserId, @RequestParam Long courseId) {
        return favoritesBl.deleteFavorite(studentUserId, courseId);
    }
}
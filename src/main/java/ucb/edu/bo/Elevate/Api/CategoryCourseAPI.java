package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.CategoryCourseBL;
import ucb.edu.bo.Elevate.Entity.CategoryCourse;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/category")
public class CategoryCourseAPI {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CategoryCourseAPI.class);
    private final CategoryCourseBL categoryCourseBl;

    @Autowired
    public CategoryCourseAPI(CategoryCourseBL categoryCourseBl) {
        this.categoryCourseBl = categoryCourseBl;
    }

    @GetMapping("/all")
    public ResponseDTO getAllCategories() {
        try {
            return categoryCourseBl.getAllCategories();
        } catch (Exception e) {
            LOGGER.error("Error al obtener categorías", e);
            return new ResponseDTO("CATEGORY-1000", "Error al obtener la lista de categorías");
        }
    }

    @GetMapping("/{id}")
    public ResponseDTO getCategoryById(@PathVariable("id") Long id) {
        try {
            return categoryCourseBl.getCategoryById(id);
        } catch (Exception e) {
            LOGGER.error("Error al obtener categoría", e);
            return new ResponseDTO("CATEGORY-1001", e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseDTO createCategory(@RequestBody CategoryCourse categoryCourse) {
        try {
            return categoryCourseBl.createCategory(categoryCourse);
        } catch (Exception e) {
            LOGGER.error("Error al crear categoría", e);
            return new ResponseDTO("CATEGORY-1002", e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseDTO updateCategory(@PathVariable("id") Long id, @RequestBody CategoryCourse categoryCourse) {
        try {
            return categoryCourseBl.updateCategoryById(id, categoryCourse);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar categoría", e);
            return new ResponseDTO("CATEGORY-1003", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteCategory(@PathVariable("id") Long id) {
        try {
            return categoryCourseBl.deleteCategoryById(id);
        } catch (Exception e) {
            LOGGER.error("Error al eliminar categoría", e);
            return new ResponseDTO("CATEGORY-1004", e.getMessage());
        }
    }
}

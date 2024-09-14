package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.CategoryCourseDAO;
import ucb.edu.bo.Elevate.Entity.CategoryCourse;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

import java.util.List;

@Service
public class CategoryCourseBL {

    private final CategoryCourseDAO categoryCourseDao;

    @Autowired
    public CategoryCourseBL(CategoryCourseDAO categoryCourseDao) {
        this.categoryCourseDao = categoryCourseDao;
    }

    public ResponseDTO getAllCategories() {
        List<CategoryCourse> categories = categoryCourseDao.findAll();
        return new ResponseDTO(categories);
    }

    public ResponseDTO getCategoryById(Long id) {
        CategoryCourse category = categoryCourseDao.findById(id).orElse(null);
        if (category == null) {
            return new ResponseDTO("CATEGORY-1000", "Category with id " + id + " does not exist");
        }
        return new ResponseDTO(category);
    }

    public ResponseDTO createCategory(CategoryCourse categoryCourse) {
        CategoryCourse createdCategory = categoryCourseDao.save(categoryCourse);
        return new ResponseDTO(createdCategory);
    }

    public ResponseDTO updateCategoryById(Long id, CategoryCourse categoryCourse) {
        CategoryCourse currentCategory = categoryCourseDao.findById(id).orElse(null);
        if (currentCategory == null) {
            return new ResponseDTO("CATEGORY-1001", "Category does not exist");
        }
        currentCategory.setNameCategory(categoryCourse.getNameCategory());
        return new ResponseDTO(categoryCourseDao.save(currentCategory));
    }

    public ResponseDTO deleteCategoryById(Long id) {
        CategoryCourse category = categoryCourseDao.findById(id).orElse(null);
        if (category == null) {
            return new ResponseDTO("CATEGORY-1002", "Category does not exist");
        }
        categoryCourseDao.delete(category);
        return new ResponseDTO("Category deleted successfully");
    }
}

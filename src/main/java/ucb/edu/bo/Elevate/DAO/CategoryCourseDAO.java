package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ucb.edu.bo.Elevate.Entity.CategoryCourse;

@Repository
public interface CategoryCourseDAO extends JpaRepository<CategoryCourse, Long> {

    @Query(value = "SELECT * FROM category_course WHERE name_category = ?1", nativeQuery = true)
    CategoryCourse findByNameCategory(String nameCategory);
}

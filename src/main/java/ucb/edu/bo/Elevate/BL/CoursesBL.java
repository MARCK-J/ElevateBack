package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.CoursesDAO;
import ucb.edu.bo.Elevate.Entity.Courses;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;
import ucb.edu.bo.Elevate.DTO.CustomResponseDTO;

import java.util.List;

@Service
public class CoursesBL {

    private final CoursesDAO coursesDao;

    @Autowired
    public CoursesBL(CoursesDAO coursesDao) {
        this.coursesDao = coursesDao;
    }

    public ResponseDTO getAllCourses() {
        List<Courses> courses = coursesDao.findAll();
        return new ResponseDTO(courses);
    }

    public ResponseDTO getCourseById(Long id) {
        Courses course = coursesDao.findById(id).orElse(null);
        if (course == null) {
            return new ResponseDTO("COURSE-1000", "Course with id " + id + " does not exist");
        }
        return new ResponseDTO(course);
    }

    public ResponseDTO createCourse(Courses course) {
        // Obtener el último course_id
        Long lastCourseId = coursesDao.findLastCourseId();
        
        // Si no hay cursos, comenzamos desde 1
        long newCourseId = (lastCourseId != null) ? lastCourseId + 1 : 1;

        // Asignar el nuevo courseId al curso
        course.setCourseId(newCourseId);
        Courses createdCourse = coursesDao.save(course);
        return new ResponseDTO(createdCourse);
    }

    public ResponseDTO updateCourseById(Long id, Courses course) {
        Courses currentCourse = coursesDao.findById(id).orElse(null);
        if (currentCourse == null) {
            return new ResponseDTO("COURSE-1001", "Course does not exist");
        }
        currentCourse.setTitle(course.getTitle());
        currentCourse.setImage(course.getImage());
        currentCourse.setDescription(course.getDescription());
        currentCourse.setDuration(course.getDuration());
        currentCourse.setRating(course.getRating());
        currentCourse.setAbilities(course.getAbilities());
        currentCourse.setAvailable(course.isAvailable());
        currentCourse.setTeacherUserId(course.getTeacherUserId());
        currentCourse.setCategoryCourseId(course.getCategoryCourseId());
        return new ResponseDTO(coursesDao.save(currentCourse));
    }

    public ResponseDTO deleteCourseById(Long id) {
        Courses course = coursesDao.findById(id).orElse(null);
        if (course == null) {
            return new ResponseDTO("COURSE-1002", "Course does not exist");
        }
        coursesDao.delete(course);
        return new ResponseDTO("Course deleted successfully");
    }

    public ResponseDTO getCoursesByDuration(String duration) {
        List<Courses> courses = coursesDao.findByDuration(duration);
        return new ResponseDTO(courses);
    }

    public ResponseDTO getCoursesByRating(double rating) {
        List<Courses> courses = coursesDao.findByRating(rating);
        return new ResponseDTO(courses);
    }

    public ResponseDTO getCoursesByUserId(Long userId) {
        List<Courses> courses = coursesDao.findByTeacherUserId(userId);
        if (courses.isEmpty()) {
            return new ResponseDTO("COURSE-1007", "No courses found for user with id " + userId);
        }
        return new ResponseDTO(courses);
    }

    public CustomResponseDTO getCoursesByTitle(String title, Pageable pageable) {
        Page<Courses> courses = coursesDao.findByTitleContainingIgnoreCase(title, pageable);
        CustomResponseDTO.Result result = new CustomResponseDTO.Result(
            courses.getContent(),
            courses.getTotalElements(),
            courses.getTotalPages(),
            courses.getNumber()
        );
        return new CustomResponseDTO("200-OK", result, null);
    }


    public CustomResponseDTO getCoursesByRating(double rating, Pageable pageable) {
        Page<Courses> courses = coursesDao.findByRatingGreaterThanEqual(rating, pageable);
        CustomResponseDTO.Result result = new CustomResponseDTO.Result(
            courses.getContent(),
            courses.getTotalElements(),
            courses.getTotalPages(),
            courses.getNumber()
        );
        return new CustomResponseDTO("200-OK", result, null);
    }

    public CustomResponseDTO getCoursesByDuration(String duration, Pageable pageable) {
        Page<Courses> courses = coursesDao.findByDurationContainingIgnoreCase(duration, pageable);
        CustomResponseDTO.Result result = new CustomResponseDTO.Result(
            courses.getContent(),
            courses.getTotalElements(),
            courses.getTotalPages(),
            courses.getNumber()
        );
        return new CustomResponseDTO("200-OK", result, null);
    }
}

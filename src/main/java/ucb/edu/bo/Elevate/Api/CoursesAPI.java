package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.CoursesBL;
import ucb.edu.bo.Elevate.Entity.Courses;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/courses")
public class CoursesAPI {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CoursesAPI.class);
    private final CoursesBL coursesBl;

    @Autowired
    public CoursesAPI(CoursesBL coursesBl) {
        this.coursesBl = coursesBl;
    }

    @GetMapping("/all")
    public ResponseDTO getAllCourses() {
        try {
            return coursesBl.getAllCourses();
        } catch (Exception e) {
            LOGGER.error("Error al obtener cursos", e);
            return new ResponseDTO("COURSE-1000", "Error al obtener la lista de cursos");
        }
    }

    @GetMapping("/{id}")
    public ResponseDTO getCourseById(@PathVariable("id") Long id) {
        try {
            return coursesBl.getCourseById(id);
        } catch (Exception e) {
            LOGGER.error("Error al obtener curso", e);
            return new ResponseDTO("COURSE-1001", e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseDTO createCourse(@RequestBody Courses course) {
        try {
            return coursesBl.createCourse(course);
        } catch (Exception e) {
            LOGGER.error("Error al crear curso", e);
            return new ResponseDTO("COURSE-1002", e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseDTO updateCourse(@PathVariable("id") Long id, @RequestBody Courses course) {
        try {
            return coursesBl.updateCourseById(id, course);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar curso", e);
            return new ResponseDTO("COURSE-1003", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteCourse(@PathVariable("id") Long id) {
        try {
            return coursesBl.deleteCourseById(id);
        } catch (Exception e) {
            LOGGER.error("Error al eliminar curso", e);
            return new ResponseDTO("COURSE-1004", e.getMessage());
        }
    }

    // get para obtener los cursos por duracion
    @GetMapping("/duration/{duration}")
    public ResponseDTO getCoursesByDuration(@PathVariable("duration") String duration) {
        try {
            return coursesBl.getCoursesByDuration(duration);
        } catch (Exception e) {
            LOGGER.error("Error al obtener cursos por duracion", e);
            return new ResponseDTO("COURSE-1005", e.getMessage());
        }
    }

    // get para obtener los cursos por rating
    @GetMapping("/rating/{rating}")
    public ResponseDTO getCoursesByRating(@PathVariable("rating") double rating) {
        try {
            return coursesBl.getCoursesByRating(rating);
        } catch (Exception e) {
            LOGGER.error("Error al obtener cursos por rating", e);
            return new ResponseDTO("COURSE-1006", e.getMessage());
        }
    }

    // get para obtener los cursos por userId
    @GetMapping("/teacher/{userId}")
    public ResponseDTO getCoursesByUserId(@PathVariable("userId") Integer userId) {
        try {
            return coursesBl.getCoursesByUserId(userId);
        } catch (Exception e) {
            LOGGER.error("Error al obtener cursos por userId", e);
            return new ResponseDTO("COURSE-1007", e.getMessage());
        }
    }
}

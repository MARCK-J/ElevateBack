package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.CoursesBL;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;
import ucb.edu.bo.Elevate.DTO.CustomResponseDTO;
import ucb.edu.bo.Elevate.Entity.Courses;

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

    @GetMapping("/duration1/{duration}")
    public ResponseDTO getCoursesByDuration(@PathVariable("duration") String duration) {
        try {
            return coursesBl.getCoursesByDuration(duration);
        } catch (Exception e) {
            LOGGER.error("Error al obtener cursos por duracion", e);
            return new ResponseDTO("COURSE-1005", e.getMessage());
        }
    }

    @GetMapping("/rating/{rating}")
    public ResponseDTO getCoursesByRating(@PathVariable("rating") double rating) {
        try {
            return coursesBl.getCoursesByRating(rating);
        } catch (Exception e) {
            LOGGER.error("Error al obtener cursos por rating", e);
            return new ResponseDTO("COURSE-1006", e.getMessage());
        }
    }

    @GetMapping("/teacher/{userId}")
    public ResponseDTO getCoursesByUserId(@PathVariable("userId") Long userId) {
        try {
            return coursesBl.getCoursesByUserId(userId);
        } catch (Exception e) {
            LOGGER.error("Error al obtener cursos por userId", e);
            return new ResponseDTO("COURSE-1007", e.getMessage());
        }
    }

    @GetMapping("/title")
    public CustomResponseDTO getCoursesByTitle(@RequestParam("title") String title,
                                               @RequestParam("page") int page,
                                               @RequestParam("size") int size,
                                               @RequestParam("sort") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return coursesBl.getCoursesByTitle(title, pageable);
    }

    @GetMapping("/rating")
    public CustomResponseDTO getCoursesByRating(@RequestParam("rating") double rating,
                                                @RequestParam("page") int page,
                                                @RequestParam("size") int size,
                                                @RequestParam("sort") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return coursesBl.getCoursesByRating(rating, pageable);
    }

    @GetMapping("/duration")
    public CustomResponseDTO getCoursesByDuration(@RequestParam("duration") String duration,
                                                  @RequestParam("page") int page,
                                                  @RequestParam("size") int size,
                                                  @RequestParam("sort") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return coursesBl.getCoursesByDuration(duration, pageable);
    }
}

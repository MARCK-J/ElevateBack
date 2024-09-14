package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.LessonsBL;
import ucb.edu.bo.Elevate.Entity.Lessons;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/lessons")
public class LessonsAPI {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LessonsAPI.class);
    private final LessonsBL lessonsBl;

    @Autowired
    public LessonsAPI(LessonsBL lessonsBl) {
        this.lessonsBl = lessonsBl;
    }

    @GetMapping("/all")
    public ResponseDTO getAllLessons() {
        try {
            return lessonsBl.getAllLessons();
        } catch (Exception e) {
            LOGGER.error("Error al obtener lecciones", e);
            return new ResponseDTO("LESSON-1000", "Error al obtener la lista de lecciones");
        }
    }

    @GetMapping("/{id}")
    public ResponseDTO getLessonById(@PathVariable("id") Long id) {
        try {
            return lessonsBl.getLessonById(id);
        } catch (Exception e) {
            LOGGER.error("Error al obtener lección", e);
            return new ResponseDTO("LESSON-1001", e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseDTO createLesson(@RequestBody Lessons lesson) {
        try {
            return lessonsBl.createLesson(lesson);
        } catch (Exception e) {
            LOGGER.error("Error al crear lección", e);
            return new ResponseDTO("LESSON-1002", e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseDTO updateLesson(@PathVariable("id") Long id, @RequestBody Lessons lesson) {
        try {
            return lessonsBl.updateLessonById(id, lesson);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar lección", e);
            return new ResponseDTO("LESSON-1003", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteLesson(@PathVariable("id") Long id) {
        try {
            return lessonsBl.deleteLessonById(id);
        } catch (Exception e) {
            LOGGER.error("Error al eliminar lección", e);
            return new ResponseDTO("LESSON-1004", e.getMessage());
        }
    }
}

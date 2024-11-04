package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.LessonsDAO;
import ucb.edu.bo.Elevate.Entity.Lessons;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

import java.util.List;

@Service
public class LessonsBL {

    private final LessonsDAO lessonsDao;

    @Autowired
    public LessonsBL(LessonsDAO lessonsDao) {
        this.lessonsDao = lessonsDao;
    }

    public ResponseDTO getAllLessons() {
        List<Lessons> lessons = lessonsDao.findAll();
        return new ResponseDTO(lessons);
    }

    public ResponseDTO getLessonById(Long id) {
        Lessons lesson = lessonsDao.findById(id).orElse(null);
        if (lesson == null) {
            return new ResponseDTO("LESSON-1000", "Lesson with id " + id + " does not exist");
        }
        return new ResponseDTO(lesson);
    }

    public ResponseDTO createLesson(Lessons lesson) {
        Lessons createdLesson = lessonsDao.save(lesson);
        return new ResponseDTO(createdLesson);
    }

    public ResponseDTO updateLessonById(Long id, Lessons lesson) {
        Lessons currentLesson = lessonsDao.findById(id).orElse(null);
        if (currentLesson == null) {
            return new ResponseDTO("LESSON-1001", "Lesson does not exist");
        }
        currentLesson.setCourseId(lesson.getCourseId());
        currentLesson.setTitle(lesson.getTitle());
        currentLesson.setDescription(lesson.getDescription());
        currentLesson.setDuration(lesson.getDuration());
        currentLesson.setContent(lesson.getContent());
        currentLesson.setVideo(lesson.getVideo());
        currentLesson.setOrder(lesson.getOrder());
        currentLesson.setComplete(lesson.isComplete());
        return new ResponseDTO(lessonsDao.save(currentLesson));
    }

    public ResponseDTO deleteLessonById(Long id) {
        Lessons lesson = lessonsDao.findById(id).orElse(null);
        if (lesson == null) {
            return new ResponseDTO("LESSON-1002", "Lesson does not exist");
        }
        lessonsDao.delete(lesson);
        return new ResponseDTO("Lesson deleted successfully");
    }

    public ResponseDTO getLessonsByCourseId(Long courseId) {
        List<Lessons> lessons = lessonsDao.findByCourseId(courseId);
        if (lessons.isEmpty()) {
            return new ResponseDTO("LESSON-1003", "No lessons found for course with id " + courseId);
        }
        return new ResponseDTO(lessons);
    }
    
}

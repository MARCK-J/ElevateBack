package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.QuizDAO;
import ucb.edu.bo.Elevate.Entity.Quizzes;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

import java.util.List;

@Service
public class QuizBL {

    private final QuizDAO quizDao;

    @Autowired
    public QuizBL(QuizDAO quizDao) {
        this.quizDao = quizDao;
    }

    public ResponseDTO getAllQuizzes() {
        List<Quizzes> quizzes = quizDao.findAll();
        return new ResponseDTO(quizzes);
    }

    public ResponseDTO getQuizById(Integer id) {
        Quizzes quiz = quizDao.findById(id).orElse(null);
        if (quiz == null) {
            return new ResponseDTO("QUIZ-1000", "Quiz with id " + id + " does not exist");
        }
        return new ResponseDTO(quiz);
    }

    public ResponseDTO createQuiz(Quizzes quiz) {
        Quizzes createdQuiz = quizDao.save(quiz);
        return new ResponseDTO(createdQuiz);
    }

    public ResponseDTO updateQuizById(Integer id, Quizzes quiz) {
        Quizzes currentQuiz = quizDao.findById(id).orElse(null);
        if (currentQuiz == null) {
            return new ResponseDTO("QUIZ-1001", "Quiz does not exist");
        }
        currentQuiz.setTitle(quiz.getTitle());
        currentQuiz.setDescription(quiz.getDescription());
        currentQuiz.setDueDate(quiz.getDueDate());
        currentQuiz.setLessonsId(quiz.getLessonsId());
        return new ResponseDTO(quizDao.save(currentQuiz));
    }

    public ResponseDTO deleteQuizById(Integer id) {
        Quizzes quiz = quizDao.findById(id).orElse(null);
        if (quiz == null) {
            return new ResponseDTO("QUIZ-1002", "Quiz does not exist");
        }
        quizDao.delete(quiz);
        return new ResponseDTO("Quiz deleted successfully");
    }

    public ResponseDTO getQuizzesByLessonId(Integer lessonId) {
        List<Quizzes> quizzes = quizDao.findByLessonsId(lessonId);
        if (quizzes.isEmpty()) {
            return new ResponseDTO("QUIZ-1003", "No quizzes found for lesson with id " + lessonId);
        }
        return new ResponseDTO(quizzes);
    }
}

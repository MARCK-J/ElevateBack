package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.QuestionDAO;
import ucb.edu.bo.Elevate.Entity.Questions;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

import java.util.List;

@Service
public class QuestionBL {

    private final QuestionDAO questionDao;

    @Autowired
    public QuestionBL(QuestionDAO questionDao) {
        this.questionDao = questionDao;
    }

    public ResponseDTO getAllQuestions() {
        List<Questions> questions = questionDao.findAll();
        return new ResponseDTO(questions);
    }

    public ResponseDTO getQuestionById(Integer id) {
        Questions question = questionDao.findById(id).orElse(null);
        if (question == null) {
            return new ResponseDTO("QUESTION-1000", "Question with id " + id + " does not exist");
        }
        return new ResponseDTO(question);
    }

    public ResponseDTO createQuestion(Questions question) {
        Questions createdQuestion = questionDao.save(question);
        return new ResponseDTO(createdQuestion);
    }

    public ResponseDTO updateQuestionById(Integer id, Questions question) {
        Questions currentQuestion = questionDao.findById(id).orElse(null);
        if (currentQuestion == null) {
            return new ResponseDTO("QUESTION-1001", "Question does not exist");
        }
        currentQuestion.setQuizId(question.getQuizId());
        currentQuestion.setContent(question.getContent());
        currentQuestion.setQuestionType(question.getQuestionType());
        return new ResponseDTO(questionDao.save(currentQuestion));
    }

    public ResponseDTO deleteQuestionById(Integer id) {
        Questions question = questionDao.findById(id).orElse(null);
        if (question == null) {
            return new ResponseDTO("QUESTION-1002", "Question does not exist");
        }
        questionDao.delete(question);
        return new ResponseDTO("Question deleted successfully");
    }

    public ResponseDTO getQuestionsByQuizId(Integer quizId) {
        List<Questions> questions = questionDao.findByQuizId(quizId);
        if (questions.isEmpty()) {
            return new ResponseDTO("QUESTION-1003", "No questions found for quiz with id " + quizId);
        }
        return new ResponseDTO(questions);
    }
}

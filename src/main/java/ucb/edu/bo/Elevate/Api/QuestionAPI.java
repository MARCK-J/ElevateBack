package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.QuestionBL;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;
import ucb.edu.bo.Elevate.Entity.Questions;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/questions")
public class QuestionAPI {

    private final QuestionBL questionBL;

    @Autowired
    public QuestionAPI(QuestionBL questionBL) {
        this.questionBL = questionBL;
    }

    @GetMapping
    public ResponseDTO getAllQuestions() {
        return questionBL.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseDTO getQuestionById(@PathVariable Integer id) {
        return questionBL.getQuestionById(id);
    }

    @PostMapping
    public ResponseDTO createQuestion(@RequestBody Questions question) {
        return questionBL.createQuestion(question);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateQuestionById(@PathVariable Integer id, @RequestBody Questions question) {
        return questionBL.updateQuestionById(id, question);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteQuestionById(@PathVariable Integer id) {
        return questionBL.deleteQuestionById(id);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseDTO getQuestionsByQuizId(@PathVariable Integer quizId) {
        return questionBL.getQuestionsByQuizId(quizId);
    }
}

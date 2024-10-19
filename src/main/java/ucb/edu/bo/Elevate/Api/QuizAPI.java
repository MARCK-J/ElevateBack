package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.QuizBL;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;
import ucb.edu.bo.Elevate.Entity.Quizzes;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/quizzes")
public class QuizAPI {

    private final QuizBL quizBL;

    @Autowired
    public QuizAPI(QuizBL quizBL) {
        this.quizBL = quizBL;
    }

    @GetMapping
    public ResponseDTO getAllQuizzes() {
        return quizBL.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public ResponseDTO getQuizById(@PathVariable Integer id) {
        return quizBL.getQuizById(id);
    }

    @PostMapping
    public ResponseDTO createQuiz(@RequestBody Quizzes quiz) {
        return quizBL.createQuiz(quiz);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateQuizById(@PathVariable Integer id, @RequestBody Quizzes quiz) {
        return quizBL.updateQuizById(id, quiz);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteQuizById(@PathVariable Integer id) {
        return quizBL.deleteQuizById(id);
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseDTO getQuizzesByLessonId(@PathVariable Integer lessonId) {
        return quizBL.getQuizzesByLessonId(lessonId);
    }
}

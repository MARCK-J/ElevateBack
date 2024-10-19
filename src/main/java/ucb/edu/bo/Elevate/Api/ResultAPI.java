package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.ResultBL;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;
import ucb.edu.bo.Elevate.Entity.Results;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/results")
public class ResultAPI {

    private final ResultBL resultBL;

    @Autowired
    public ResultAPI(ResultBL resultBL) {
        this.resultBL = resultBL;
    }

    @GetMapping
    public ResponseDTO getAllResults() {
        return resultBL.getAllResults();
    }

    @GetMapping("/{id}")
    public ResponseDTO getResultById(@PathVariable Integer id) {
        return resultBL.getResultById(id);
    }

    @PostMapping
    public ResponseDTO createResult(@RequestBody Results result) {
        return resultBL.createResult(result);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateResultById(@PathVariable Integer id, @RequestBody Results result) {
        return resultBL.updateResultById(id, result);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteResultById(@PathVariable Integer id) {
        return resultBL.deleteResultById(id);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseDTO getResultsByQuizId(@PathVariable Integer quizId) {
        return resultBL.getResultsByQuizId(quizId);
    }

    @GetMapping("/student/{studentUserId}")
    public ResponseDTO getResultsByStudentUserId(@PathVariable Integer studentUserId) {
        return resultBL.getResultsByStudentUserId(studentUserId);
    }
}

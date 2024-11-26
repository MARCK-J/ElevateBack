package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.ResultDAO;
import ucb.edu.bo.Elevate.Entity.Results;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ResultBL {

    private final ResultDAO resultDao;

    @Autowired
    public ResultBL(ResultDAO resultDao) {
        this.resultDao = resultDao;
    }

    public ResponseDTO getAllResults() {
        List<Results> results = resultDao.findAll();
        return new ResponseDTO(results);
    }

    public ResponseDTO getResultById(Integer id) {
        Results result = resultDao.findById(id).orElse(null);
        if (result == null) {
            return new ResponseDTO("RESULT-1000", "Result with id " + id + " does not exist");
        }
        return new ResponseDTO(result);
    }

    public ResponseDTO createResult(Results result) {
        Results createdResult = resultDao.save(result);
        return new ResponseDTO(createdResult);
    }

    public ResponseDTO updateResultById(Integer id, Results result) {
        Results currentResult = resultDao.findById(id).orElse(null);
        if (currentResult == null) {
            return new ResponseDTO("RESULT-1001", "Result does not exist");
        }
        currentResult.setScore(result.getScore());
        currentResult.setSubmissionDate(result.getSubmissionDate());
        currentResult.setQuizId(result.getQuizId());
        currentResult.setStudentUserId(result.getStudentUserId());
        return new ResponseDTO(resultDao.save(currentResult));
    }

    public ResponseDTO deleteResultById(Integer id) {
        Results result = resultDao.findById(id).orElse(null);
        if (result == null) {
            return new ResponseDTO("RESULT-1002", "Result does not exist");
        }
        resultDao.delete(result);
        return new ResponseDTO("Result deleted successfully");
    }

    public ResponseDTO getResultsByQuizId(Integer quizId) {
        List<Results> results = resultDao.findByQuizId(quizId);
        if (results.isEmpty()) {
            return new ResponseDTO("RESULT-1003", "No results found for quiz with id " + quizId);
        }
        return new ResponseDTO(results);
    }

    public ResponseDTO getResultsByStudentUserId(Integer studentUserId) {
        List<Results> results = resultDao.findByStudentUserId(studentUserId);
        if (results.isEmpty()) {
            return new ResponseDTO("RESULT-1004", "No results found for student with id " + studentUserId);
        }
        return new ResponseDTO(results);
    }

    public ResponseDTO getQualificationByQuizIdAndStudentUserId(Long quizId, Long studentUserId) {
        Optional<Results> result = resultDao.findByQuizIdAndStudentUserId(quizId, studentUserId);
        if (result.isEmpty()) {
            return new ResponseDTO("RESULT-1003", "No result found for quiz with id " + quizId + " and student with id " + studentUserId);
        }

        return new ResponseDTO(result.get().getScore());
    }
}

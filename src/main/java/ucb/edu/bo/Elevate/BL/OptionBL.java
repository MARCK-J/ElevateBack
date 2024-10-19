package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.OptionDAO;
import ucb.edu.bo.Elevate.Entity.Option;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

import java.util.List;

@Service
public class OptionBL {

    private final OptionDAO optionDao;

    @Autowired
    public OptionBL(OptionDAO optionDao) {
        this.optionDao = optionDao;
    }

    public ResponseDTO getAllOptions() {
        List<Option> options = optionDao.findAll();
        return new ResponseDTO(options);
    }

    public ResponseDTO getOptionById(Integer id) {
        Option option = optionDao.findById(id).orElse(null);
        if (option == null) {
            return new ResponseDTO("OPTION-1000", "Option with id " + id + " does not exist");
        }
        return new ResponseDTO(option);
    }

    public ResponseDTO createOption(Option option) {
        Option createdOption = optionDao.save(option);
        return new ResponseDTO(createdOption);
    }

    public ResponseDTO updateOptionById(Integer id, Option option) {
        Option currentOption = optionDao.findById(id).orElse(null);
        if (currentOption == null) {
            return new ResponseDTO("OPTION-1001", "Option does not exist");
        }
        currentOption.setQuestionId(option.getQuestionId());
        currentOption.setContent(option.getContent());
        currentOption.setCorrect(option.isCorrect());
        return new ResponseDTO(optionDao.save(currentOption));
    }

    public ResponseDTO deleteOptionById(Integer id) {
        Option option = optionDao.findById(id).orElse(null);
        if (option == null) {
            return new ResponseDTO("OPTION-1002", "Option does not exist");
        }
        optionDao.delete(option);
        return new ResponseDTO("Option deleted successfully");
    }

    public ResponseDTO getOptionsByQuestionId(Integer questionId) {
        List<Option> options = optionDao.findByQuestionId(questionId);
        if (options.isEmpty()) {
            return new ResponseDTO("OPTION-1003", "No options found for question with id " + questionId);
        }
        return new ResponseDTO(options);
    }
}

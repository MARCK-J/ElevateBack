package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.OptionBL;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;
import ucb.edu.bo.Elevate.Entity.Option;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/options")
public class OptionAPI {

    private final OptionBL optionBL;

    @Autowired
    public OptionAPI(OptionBL optionBL) {
        this.optionBL = optionBL;
    }

    @GetMapping
    public ResponseDTO getAllOptions() {
        return optionBL.getAllOptions();
    }

    @GetMapping("/{id}")
    public ResponseDTO getOptionById(@PathVariable Integer id) {
        return optionBL.getOptionById(id);
    }

    @PostMapping
    public ResponseDTO createOption(@RequestBody Option option) {
        return optionBL.createOption(option);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateOptionById(@PathVariable Integer id, @RequestBody Option option) {
        return optionBL.updateOptionById(id, option);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteOptionById(@PathVariable Integer id) {
        return optionBL.deleteOptionById(id);
    }

    @GetMapping("/question/{questionId}")
    public ResponseDTO getOptionsByQuestionId(@PathVariable Integer questionId) {
        return optionBL.getOptionsByQuestionId(questionId);
    }
}

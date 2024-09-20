package ucb.edu.bo.Elevate.email.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import ucb.edu.bo.Elevate.email.Model.MailStructure;
import ucb.edu.bo.Elevate.email.Service.MailService;

@RestController
@RequestMapping("/mail")
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permitir solicitudes desde cualquier origen
public class MailController {
    
    @Autowired
    private MailService mailService;

    @PostMapping("/send/{mail}")
    public String sendMail(@PathVariable String mail, @RequestBody MailStructure mailStructure){
        mailService.sendMail(mail, mailStructure);
        return "Envio exitoso";
    }

}

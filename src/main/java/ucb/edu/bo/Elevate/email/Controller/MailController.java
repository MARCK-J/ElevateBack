package ucb.edu.bo.Elevate.email.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import ucb.edu.bo.Elevate.email.Model.MailStructure;
import ucb.edu.bo.Elevate.email.Service.MailService;

@RestController
@RequestMapping("/api/v1/mail")
@CrossOrigin(origins = "*", allowedHeaders = "*") // Permitir solicitudes desde cualquier origen
public class MailController {
    
    @Autowired
    private MailService mailService;

    @PostMapping("/send/{mail}")
    public ResponseEntity<String> sendMail(@PathVariable String mail, @RequestBody MailStructure mailStructure) {
        try {
            mailService.sendMail(mail, mailStructure);
            return ResponseEntity.ok("Envío exitoso");
        } catch (Exception e) {
            // Manejo del error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al enviar el correo: " + e.getMessage());
        }
    }
}

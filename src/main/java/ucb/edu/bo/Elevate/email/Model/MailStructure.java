package ucb.edu.bo.Elevate.email.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailStructure {
    private String subject;
    private String message;

    // Add the constructor
    public MailStructure(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }
}


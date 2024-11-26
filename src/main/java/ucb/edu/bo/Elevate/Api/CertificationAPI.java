package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.CertificationBL;
import ucb.edu.bo.Elevate.Entity.Certification;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/certifications")
public class CertificationAPI {

    private final CertificationBL certificationBl;

    @Autowired
    public CertificationAPI(CertificationBL certificationBl) {
        this.certificationBl = certificationBl;
    }

    @PostMapping("/generate")
    public ResponseDTO generateCertification(@RequestParam Long studentUserId, @RequestParam Long courseId) {
        Certification certification = certificationBl.generateCertification(studentUserId, courseId);
        return new ResponseDTO(certification);
    }
}
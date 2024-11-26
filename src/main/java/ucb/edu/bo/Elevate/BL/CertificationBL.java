package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.CertificationDAO;
import ucb.edu.bo.Elevate.Entity.Certification;

import java.util.Date;

@Service
public class CertificationBL {

    private final CertificationDAO certificationDao;

    @Autowired
    public CertificationBL(CertificationDAO certificationDao) {
        this.certificationDao = certificationDao;
    }

    public Certification generateCertification(Long studentUserId, Long courseId) {
        Certification certification = new Certification();
        certification.setStudentUserId(studentUserId);
        certification.setCourseId(courseId);
        certification.setIssueDate(new Date());
        return certificationDao.save(certification);
    }
}
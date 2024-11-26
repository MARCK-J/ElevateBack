package ucb.edu.bo.Elevate.BL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.CertificationDAO;
import ucb.edu.bo.Elevate.Entity.Certification;

import java.util.Date;

@Service
public class CertificationBL {

    private static final Logger LOGGER = LoggerFactory.getLogger(CertificationBL.class);
    private final CertificationDAO certificationDao;

    @Autowired
    public CertificationBL(CertificationDAO certificationDao) {
        this.certificationDao = certificationDao;
    }

    public Certification generateCertification(Long studentUserId, Long courseId) {
        LOGGER.info("Generating certification for studentUserId: {} and courseId: {}", studentUserId, courseId);
        Certification certification = new Certification();
        certification.setStudentUserId(studentUserId);
        certification.setCourseId(courseId);
        certification.setIssueDate(new Date());
        Certification savedCertification = certificationDao.save(certification);
        LOGGER.info("Saved certification: {}", savedCertification);
        return savedCertification;
    }
}
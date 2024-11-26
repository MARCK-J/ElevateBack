package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.EnrollmentsDAO;
import ucb.edu.bo.Elevate.Entity.Enrollments;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;
import ucb.edu.bo.Elevate.Entity.Certification;

import java.util.List;

@Service
public class EnrollmentsBL {

    private final EnrollmentsDAO enrollmentsDao;
    private final CertificationBL certificationBl;

    @Autowired
    public EnrollmentsBL(EnrollmentsDAO enrollmentsDao, CertificationBL certificationBl) {
        this.enrollmentsDao = enrollmentsDao;
        this.certificationBl = certificationBl;
    }

    public ResponseDTO getAllEnrollments() {
        List<Enrollments> enrollments = enrollmentsDao.findAll();
        return new ResponseDTO(enrollments);
    }

    public ResponseDTO getEnrollmentById(Long id) {
        Enrollments enrollment = enrollmentsDao.findById(id).orElse(null);
        if (enrollment == null) {
            return new ResponseDTO("ENROLLMENT-1000", "Enrollment with id " + id + " does not exist");
        }
        return new ResponseDTO(enrollment);
    }

    public ResponseDTO createEnrollment(Enrollments enrollment) {
        Long lastEnrollmentId = enrollmentsDao.findLastEnrollmentId();
        long newEnrollmentId = (lastEnrollmentId != null) ? lastEnrollmentId + 1 : 1;
        enrollment.setEnrollmentId(newEnrollmentId);
        Enrollments createdEnrollment = enrollmentsDao.save(enrollment);
        return new ResponseDTO(createdEnrollment);
    }

    public ResponseDTO updateEnrollmentById(Long id, Enrollments enrollment) {
        Enrollments currentEnrollment = enrollmentsDao.findById(id).orElse(null);
        if (currentEnrollment == null) {
            return new ResponseDTO("ENROLLMENT-1001", "Enrollment does not exist");
        }
        currentEnrollment.setEnrollmentDate(enrollment.getEnrollmentDate());
        currentEnrollment.setStudentUserId(enrollment.getStudentUserId());
        currentEnrollment.setCoursesCourseId(enrollment.getCoursesCourseId());
        currentEnrollment.setCompleted(enrollment.isCompleted());
        return new ResponseDTO(enrollmentsDao.save(currentEnrollment));
    }

    public ResponseDTO deleteEnrollmentById(Long id) {
        Enrollments enrollment = enrollmentsDao.findById(id).orElse(null);
        if (enrollment == null) {
            return new ResponseDTO("ENROLLMENT-1002", "Enrollment does not exist");
        }
        enrollmentsDao.delete(enrollment);
        return new ResponseDTO("Enrollment deleted successfully");
    }

    public ResponseDTO getEnrollmentsByStudentId(Long studentUserId) {
        List<Enrollments> enrollments = enrollmentsDao.findByStudentUserId(studentUserId);
        if (enrollments.isEmpty()) {
            return new ResponseDTO("ENROLLMENT-1002", "No enrollments found for student with id " + studentUserId);
        }
        return new ResponseDTO(enrollments);
    }

    public void completeCourse(Long enrollmentId) {
        Enrollments enrollment = enrollmentsDao.findById(enrollmentId).orElseThrow(() -> new RuntimeException("Enrollment not found"));
        enrollment.setCompleted(true);
        enrollmentsDao.save(enrollment);

        // Generate certification
        certificationBl.generateCertification(enrollment.getStudentUserId(), enrollment.getCoursesCourseId());
    }
}
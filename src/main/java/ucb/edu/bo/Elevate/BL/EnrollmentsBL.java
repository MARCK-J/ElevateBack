package ucb.edu.bo.Elevate.BL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.Elevate.DAO.EnrollmentsDAO;
import ucb.edu.bo.Elevate.Entity.Enrollments;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

import java.util.List;

@Service
public class EnrollmentsBL {

    private final EnrollmentsDAO enrollmentsDao;

    @Autowired
    public EnrollmentsBL(EnrollmentsDAO enrollmentsDao) {
        this.enrollmentsDao = enrollmentsDao;
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
        // Obtener el último enrollment_id
        Long lastEnrollmentId = enrollmentsDao.findLastEnrollmentId();
        
        // Si no hay inscripciones, comenzamos desde 1
        long newEnrollmentId = (lastEnrollmentId != null) ? lastEnrollmentId + 1 : 1;

        // Asignar el nuevo enrollmentId al registro
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

    // getenrollement by userid
    public ResponseDTO getEnrollmentByUserId(Long userId) {
        List<Enrollments> enrollments = enrollmentsDao.findByStudentUserId(userId);
        return new ResponseDTO(enrollments);
    }
}
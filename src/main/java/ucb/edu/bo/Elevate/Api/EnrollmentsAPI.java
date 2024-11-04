package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.EnrollmentsBL;
import ucb.edu.bo.Elevate.Entity.Enrollments;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/enrollments")
public class EnrollmentsAPI {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EnrollmentsAPI.class);
    private final EnrollmentsBL enrollmentsBl;

    @Autowired
    public EnrollmentsAPI(EnrollmentsBL enrollmentsBl) {
        this.enrollmentsBl = enrollmentsBl;
    }

    @GetMapping("/all")
    public ResponseDTO getAllEnrollments() {
        try {
            return enrollmentsBl.getAllEnrollments();
        } catch (Exception e) {
            LOGGER.error("Error al obtener inscripciones", e);
            return new ResponseDTO("ENROLLMENT-1000", "Error al obtener la lista de inscripciones");
        }
    }

    @GetMapping("/{id}")
    public ResponseDTO getEnrollmentById(@PathVariable("id") Long id) {
        try {
            return enrollmentsBl.getEnrollmentById(id);
        } catch (Exception e) {
            LOGGER.error("Error al obtener inscripción", e);
            return new ResponseDTO("ENROLLMENT-1001", e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseDTO createEnrollment(@RequestBody Enrollments enrollment) {
        try {
            return enrollmentsBl.createEnrollment(enrollment);
        } catch (Exception e) {
            LOGGER.error("Error al crear inscripción", e);
            return new ResponseDTO("ENROLLMENT-1002", e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseDTO updateEnrollment(@PathVariable("id") Long id, @RequestBody Enrollments enrollment) {
        try {
            return enrollmentsBl.updateEnrollmentById(id, enrollment);
        } catch (Exception e) {
            LOGGER.error("Error al actualizar inscripción", e);
            return new ResponseDTO("ENROLLMENT-1003", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteEnrollment(@PathVariable("id") Long id) {
        try {
            return enrollmentsBl.deleteEnrollmentById(id);
        } catch (Exception e) {
            LOGGER.error("Error al eliminar inscripción", e);
            return new ResponseDTO("ENROLLMENT-1004", e.getMessage());
        }
    }

    // getmapping por studentUserId
    @GetMapping("/student/{studentUserId}")
    public ResponseDTO getEnrollmentsByStudentId(@PathVariable("studentUserId") Long studentUserId) {
        try {
            return enrollmentsBl.getEnrollmentsByStudentId(studentUserId);
        } catch (Exception e) {
            LOGGER.error("Error al obtener inscripciones", e);
            return new ResponseDTO("ENROLLMENT-1002", e.getMessage());
        }
    }
}
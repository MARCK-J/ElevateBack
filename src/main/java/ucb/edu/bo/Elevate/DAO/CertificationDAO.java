package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.edu.bo.Elevate.Entity.Certification;

@Repository
public interface CertificationDAO extends JpaRepository<Certification, Long> {
}
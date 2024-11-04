package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import ucb.edu.bo.Elevate.Entity.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Users findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    Users findByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE user_id = ?1", nativeQuery = true)
    List<Users> findUserByUserId(Long userId);

    @Query(value = "SELECT * FROM users WHERE role = ?1", nativeQuery = true)
    List<Users> findUsersByRole(int role);

    @Query(value = "SELECT * FROM users WHERE verification = ?1", nativeQuery = true)
    List<Users> findUsersByVerification(boolean verification);

    @Query(value = "SELECT user_id FROM users ORDER BY user_id DESC LIMIT 1", nativeQuery = true)
    Long findLastUserId();
}

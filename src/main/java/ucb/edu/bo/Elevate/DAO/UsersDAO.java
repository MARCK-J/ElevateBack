package ucb.edu.bo.Elevate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import ucb.edu.bo.Elevate.Entity.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
    Users findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE user_id = ?1", nativeQuery = true)
    List<Users> findUserByUserId(int userId);
}

package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.UsersBL;
import ucb.edu.bo.Elevate.Entity.Users;
import ucb.edu.bo.Elevate.Exception.UserException;
import ucb.edu.bo.Elevate.DTO.LoginRequestDTO;
import ucb.edu.bo.Elevate.DTO.PasswordChangeRequestDTO;
import ucb.edu.bo.Elevate.DTO.PasswordRecoveryRequestDTO;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/user")
public class UsersAPI {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UsersAPI.class);
    private UsersBL userBl;

    @Autowired
    public UsersAPI(UsersBL userBl) {
        this.userBl = userBl;
    }

    // Endpoint para el registro (Sign-up)
    @PostMapping("/signup")
    public ResponseDTO signUp(@RequestBody Users user) {
        try {
            Users createdUser = userBl.signUp(user);
            LOGGER.info("Usuario registrado correctamente");
            return new ResponseDTO(createdUser);
        } catch (UserException e) {
            LOGGER.error("Error en el registro del usuario", e);
            return new ResponseDTO("USER-1000", e.getMessage());
        }
    }

    // Endpoint para el inicio de sesión (Log-in)
    @PostMapping("/login")
    public ResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            Users user = userBl.login(loginRequestDTO.getIdentifier(), loginRequestDTO.getPassword());
            LOGGER.info("Inicio de sesión exitoso");
            return new ResponseDTO(user);
        } catch (UserException e) {
            LOGGER.error("Error en el inicio de sesión", e);
            return new ResponseDTO("USER-1001", e.getMessage());
        }
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping("/all")
    public ResponseDTO getAllUsers() {
        try {
            return new ResponseDTO(userBl.getAllUsers());
        } catch (Exception e) {
            LOGGER.error("Error al obtener usuarios", e);
            return new ResponseDTO("USER-1002", "Error al obtener la lista de usuarios");
        }
    }

    // Endpoint para obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseDTO getUserById(@PathVariable("id") Long id) {
        try {
            return new ResponseDTO(userBl.getUserById(id));
        } catch (UserException e) {
            LOGGER.error("Error al obtener usuario", e);
            return new ResponseDTO("USER-1003", e.getMessage());
        }
    }

    // Endpoint para actualizar un usuario
    @PutMapping("/{id}")
    public ResponseDTO updateUser(@PathVariable("id") Long id, @RequestBody Users userDetails) {
        try {
            return new ResponseDTO(userBl.updateUser(id, userDetails));
        } catch (UserException e) {
            LOGGER.error("Error al actualizar usuario", e);
            return new ResponseDTO("USER-1004", e.getMessage());
        }
    }

    // Endpoint para eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseDTO deleteUser(@PathVariable("id") Long id) {
        try {
            userBl.deleteUser(id);
            LOGGER.info("Usuario eliminado correctamente");
            return new ResponseDTO("Usuario eliminado correctamente");
        } catch (UserException e) {
            LOGGER.error("Error al eliminar usuario", e);
            return new ResponseDTO("USER-1005", e.getMessage());
        }
    }

    // Endpoint para obtener usuarios por rol
    @GetMapping("/role/{role}")
    public ResponseDTO getUsersByRole(@PathVariable("role") int role) {
        try {
            return new ResponseDTO(userBl.getUsersByRole(role));
        } catch (UserException e) {
            LOGGER.error("Error al obtener usuarios por rol", e);
            return new ResponseDTO("USER-1006", e.getMessage());
        }
    }

    @PostMapping("/recover-password")
    public ResponseDTO recoverPassword(@RequestBody PasswordRecoveryRequestDTO passwordRecoveryRequestDTO) {
        try {
            return userBl.recoverPassword(passwordRecoveryRequestDTO.getEmail());
        } catch (UserException e) {
            LOGGER.error("Error in password recovery", e);
            return new ResponseDTO("USER-1008", e.getMessage());
        }
    }

    @PostMapping("/change-password")
    public ResponseDTO changePassword(@RequestBody PasswordChangeRequestDTO passwordChangeRequestDTO) {
        try {
            return userBl.changePassword(passwordChangeRequestDTO.getEmail(), passwordChangeRequestDTO.getOldPassword(), passwordChangeRequestDTO.getNewPassword());
        } catch (UserException e) {
            LOGGER.error("Error in changing password", e);
            return new ResponseDTO("USER-1009", e.getMessage());
        }
    }
}

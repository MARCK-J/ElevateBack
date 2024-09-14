package ucb.edu.bo.Elevate.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.edu.bo.Elevate.BL.UserBl;
import ucb.edu.bo.Elevate.Entity.Users;
import ucb.edu.bo.Elevate.Exception.UserException;
import ucb.edu.bo.Elevate.DTO.LoginRequestDTO;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/user")
public class UserAPI {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserAPI.class);

    private UserBl userBl;

    @Autowired
    public UserAPI(UserBl userBl) {
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
            Users user = userBl.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
            LOGGER.info("Inicio de sesión exitoso");
            return new ResponseDTO(user);
        } catch (UserException e) {
            LOGGER.error("Error en el inicio de sesión", e);
            return new ResponseDTO("USER-1001", e.getMessage());
        }
    }
}


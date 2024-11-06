package ucb.edu.bo.Elevate.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ucb.edu.bo.Elevate.DAO.StudentDAO;
import ucb.edu.bo.Elevate.DAO.TeacherDAO;
import ucb.edu.bo.Elevate.DAO.UsersDAO;
import ucb.edu.bo.Elevate.DTO.ResponseDTO;
import ucb.edu.bo.Elevate.Entity.Student;
import ucb.edu.bo.Elevate.Entity.Teacher;
import ucb.edu.bo.Elevate.Entity.Users;
import ucb.edu.bo.Elevate.Exception.UserException;
import ucb.edu.bo.Elevate.email.Model.MailStructure;
import ucb.edu.bo.Elevate.email.Service.MailService;

@Service
public class UsersBL {

    private UsersDAO usersDao;
    private StudentDAO studentDao;
    private TeacherDAO teacherDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private MailService mailService;

    @Autowired
    public UsersBL(UsersDAO usersDao, StudentDAO studentDao, TeacherDAO teacherDao, BCryptPasswordEncoder bCryptPasswordEncoder, MailService mailService) {
        this.usersDao = usersDao;
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mailService = mailService;
    }

    // Registro (Sign-up)
    public Users signUp(Users user) throws UserException {
        // Verificar si el email ya está registrado
        Users existingUser = usersDao.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new UserException("El correo ya está registrado");
        }

        // Obtener el último user_id
        Long lastUserId = usersDao.findLastUserId();
        
        // Si no hay usuarios, comenzamos desde 1 (o el número que desees)
        long newUserId = (lastUserId != null) ? lastUserId + 1 : 1;

        // Asignar el nuevo userId al usuario
        user.setUserId(newUserId);
    
        // Hashear la contraseña
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // Guardar el usuario
        Users savedUser = usersDao.save(user);
    
        // Registrar en Student o Teacher según el rol
        if (user.getRole() == 1) {
            Student student = new Student();
            student.setUserId(savedUser.getUserId());
            student.setEnrollmentDate(user.getDateJoin());
            studentDao.save(student);
        } else if (user.getRole() == 2) {
            Teacher teacher = new Teacher();
            teacher.setUserId(savedUser.getUserId());
            teacher.setEnrollmentDate(user.getDateJoin());
            teacherDao.save(teacher);
        } else {
            throw new UserException("Rol no válido");
        }
    
        return savedUser;
    }
    

    // Inicio de sesión (Log-in) (email/username y contraseña)
    public Users login(String identifier, String password) throws UserException {
        // Buscar al usuario por email o username
        Users user = usersDao.findByEmail(identifier);
        if (user == null) {
            user = usersDao.findByUsername(identifier);
            if (user == null) {
                throw new UserException("Correo, nombre de usuario o contraseña incorrectos");
            }
        }
        
        // Verificar si la contraseña proporcionada coincide con la contraseña almacenada
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new UserException("Correo o contraseña incorrectos");
        }

        // Verificar el rol y retornar información sobre si es estudiante o profesor
        if (user.getRole() == 1) { // Estudiante
            Student student = studentDao.findStudentByUserId(user.getUserId()).stream().findFirst().orElse(null);
            if (student == null) {
                throw new UserException("El usuario no está registrado como estudiante");
            }
            user.setPassword(null); // Eliminar la contraseña antes de retornar el usuario
            return user;
        } else if (user.getRole() == 2) { // Profesor
            Teacher teacher = teacherDao.findTeacherByUserId(user.getUserId()).stream().findFirst().orElse(null);
            if (teacher == null) {
                throw new UserException("El usuario no está registrado como profesor");
            }
            user.setPassword(null); // Eliminar la contraseña antes de retornar el usuario
            return user;
        } else {
            throw new UserException("Rol no válido");
        }
    }

    // Obtener todos los usuarios
    public List<Users> getAllUsers() {
        return usersDao.findAll();
    }

    // Obtener un usuario por ID
    public Users getUserById(Long userId) throws UserException {
        return usersDao.findById(userId).orElseThrow(() -> new UserException("Usuario no encontrado"));
    }

    // Actualizar un usuario
    public Users updateUser(Long userId, Users userDetails) throws UserException {
        Users user = usersDao.findById(userId).orElseThrow(() -> new UserException("Usuario no encontrado"));
        
        // Actualizar los detalles del usuario
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        
        }
        user.setVerification(userDetails.isVerification());
        user.setActivation(userDetails.isActivation());
        return usersDao.save(user);
    }

    // Eliminar un usuario
    public void deleteUser(Long userId) throws UserException {
        Users user = usersDao.findById(userId).orElseThrow(() -> new UserException("Usuario no encontrado"));
        usersDao.delete(user);
    }

    // Obtener usuarios por rol
    public List<Users> getUsersByRole(int role) throws UserException {
        List<Users> users = usersDao.findUsersByRole(role);
        if (users.isEmpty()) {
            throw new UserException("No se encontraron usuarios con este rol");
        }
        return users;
    }
    
    // Obtener usuarios por username
    public Users getUserByUsername(String username) throws UserException {
        Users user = usersDao.findByUsername(username);
        if (user == null) {
            throw new UserException("Usuario no encontrado");
        }
        return user;
    }

    public ResponseDTO recoverPassword(String email) throws UserException {
        Users user = usersDao.findByEmail(email);
        if (user == null) {
            throw new UserException("No user found with the provided email");
        }

        // Generate a temporary password or a password reset token
        String tempPassword = generateTemporaryPassword();
        user.setPassword(bCryptPasswordEncoder.encode(tempPassword));
        usersDao.save(user);

        // Send the temporary password to the user's email
        MailStructure mailStructure = new MailStructure("Password Recovery", "Your temporary password is: " + tempPassword);
        mailService.sendMail(email, mailStructure);

        return new ResponseDTO("A temporary password has been sent to your email");
    }

    private String generateTemporaryPassword() {
        // Implement your logic to generate a temporary password
        return "tempPassword123";
    }

    public ResponseDTO changePassword(String email, String oldPassword, String newPassword) throws UserException {
        Users user = usersDao.findByEmail(email);
        if (user == null) {
            throw new UserException("No user found with the provided email");
        }

        if (!bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            throw new UserException("Old password is incorrect");
        }

        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        usersDao.save(user);

        return new ResponseDTO("Password has been changed successfully");
    }
}

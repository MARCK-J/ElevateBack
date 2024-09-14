package ucb.edu.bo.Elevate.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ucb.edu.bo.Elevate.DAO.StudentDAO;
import ucb.edu.bo.Elevate.DAO.TeacherDAO;
import ucb.edu.bo.Elevate.DAO.UsersDAO;
import ucb.edu.bo.Elevate.Entity.Student;
import ucb.edu.bo.Elevate.Entity.Teacher;
import ucb.edu.bo.Elevate.Entity.Users;
import ucb.edu.bo.Elevate.Exception.UserException;

@Service
public class UsersBL {

    private UsersDAO usersDao;
    private StudentDAO studentDao;
    private TeacherDAO teacherDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsersBL(UsersDAO usersDao, StudentDAO studentDao, TeacherDAO teacherDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersDao = usersDao;
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Registro (Sign-up)
    public Users signUp(Users user) throws UserException {
        // Verificar si el email ya está registrado
        Users existingUser = usersDao.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new UserException("El correo ya está registrado");
        }

        // Hashear la contraseña
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // Guardar el usuario
        Users savedUser = usersDao.save(user);

        // Si el rol es de estudiante, registrar en la tabla Student
        if (user.getRole() == 1) { // 1 representa el rol de Student
            Student student = new Student();
            student.setUserId(savedUser.getUserId());
            student.setEnrollmentDate(user.getDateJoin()); // Usar la fecha de registro como fecha de inscripción
            studentDao.save(student);
        } 
        // Si el rol es de profesor, registrar en la tabla Teacher
        else if (user.getRole() == 2) { // 2 representa el rol de Teacher
            Teacher teacher = new Teacher();
            teacher.setUserId(savedUser.getUserId());
            teacher.setEnrollmentDate(user.getDateJoin()); // Usar la fecha de registro como fecha de inscripción
            teacherDao.save(teacher);
        } else {
            throw new UserException("Rol no válido");
        }

        return savedUser;
    }

    // Inicio de sesión (Log-in)
    public Users login(String email, String password) throws UserException {
        // Buscar al usuario por email
        Users user = usersDao.findByEmail(email);
        if (user == null) {
            throw new UserException("Correo o contraseña incorrectos");
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
}

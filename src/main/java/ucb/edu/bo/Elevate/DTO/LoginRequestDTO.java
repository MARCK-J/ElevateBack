package ucb.edu.bo.Elevate.DTO;

public class LoginRequestDTO {
    private String email;
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String correo, String password) {
        this.email = correo;
        this.password = password;
    }

    //dame getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String correo) {
        this.email = correo;
    }

    //dame getters y setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //toString
    @Override
    public String toString() {
        return "LoginRequestDTO [password=" + password + ", usuario=" + email + "]";
    }
}


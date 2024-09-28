package ucb.edu.bo.Elevate.DTO;

public class LoginRequestDTO {
    private String identifier;
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String identifies, String password) {
        this.identifier = identifies;
        this.password = password;
    }

    //dame getters y setters
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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
        return "LoginRequestDTO{" +
                "identifier='" + identifier + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


package ucb.edu.bo.Elevate.DTO;

public class PasswordChangeRequestDTO {
    private String email;
    private String newPassword;

    public PasswordChangeRequestDTO() {
    }

    public PasswordChangeRequestDTO(String email, String newPassword) {
        this.email = email;
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "PasswordChangeRequestDTO{" +
                "email='" + email + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
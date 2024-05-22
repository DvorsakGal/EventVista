package si.um.ris.dto;

/**
 * Created by Uporabnik on 22. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
public class RegistrationDTO {
    //btw DTO pomeni data transfer object

    private String username;
    private String email;
    private String password;

    public RegistrationDTO() {
        super();
    }

    public RegistrationDTO(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegistrationDTO info{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}

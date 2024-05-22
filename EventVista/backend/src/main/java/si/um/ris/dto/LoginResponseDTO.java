package si.um.ris.dto;

import si.um.ris.models.AppUser;

/**
 * Created by Uporabnik on 23. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
public class LoginResponseDTO {
    private AppUser user;
    private String jwt;

    public LoginResponseDTO() {
        super();
    }

    public LoginResponseDTO(AppUser user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}

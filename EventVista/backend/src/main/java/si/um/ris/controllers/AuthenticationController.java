package si.um.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.ris.dto.LoginResponseDTO;
import si.um.ris.dto.RegistrationDTO;
import si.um.ris.models.AppUser;
import si.um.ris.service.AuthenticationService;

/**
 * Created by Uporabnik on 22. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public AppUser registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getEmail(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

}

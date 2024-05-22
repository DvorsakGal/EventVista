package si.um.ris.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import si.um.ris.dto.LoginResponseDTO;
import si.um.ris.models.AppUser;
import si.um.ris.models.Role;
import si.um.ris.repository.IAppUserRepo;
import si.um.ris.repository.IRoleRepo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Uporabnik on 22. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private IAppUserRepo userRepo;
    @Autowired
    private IRoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public AppUser registerUser(String username, String email, String password) {
        String encodedPAssword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepo.save(new AppUser(0L, username, email, encodedPAssword, authorities));
    }

    public LoginResponseDTO loginUser(String username, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepo.findUserByUsername(username).get(), token);

        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, "");
        }
    }

}

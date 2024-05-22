package si.um.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import si.um.ris.models.AppUser;
import si.um.ris.models.Role;
import si.um.ris.repository.IAppUserRepo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Uporabnik on 21. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private IAppUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");

        return userRepo.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
}

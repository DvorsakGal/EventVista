package si.um.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.ris.models.AppUser;
import si.um.ris.models.Event;
import si.um.ris.repository.IAppUserRepo;
import si.um.ris.repository.IEventRepo;

import java.util.Optional;

/**
 * Created by Uporabnik on 21. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private IAppUserRepo userRepository;

    @GetMapping("/")
    public String helloUsers() {
        return "Hello users";
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        Optional<AppUser> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            AppUser userToDelete = userOptional.get();

            // Delete the user from the repository
            userRepository.delete(userToDelete);

            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

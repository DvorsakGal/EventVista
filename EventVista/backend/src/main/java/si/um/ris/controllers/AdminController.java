package si.um.ris.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Uporabnik on 21. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @GetMapping("/")
    public String helloAdmin() {
        return "Hello Admin";
    }
}

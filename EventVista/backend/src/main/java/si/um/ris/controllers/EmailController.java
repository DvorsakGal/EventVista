package si.um.ris.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.ris.models.Email;
import si.um.ris.service.EmailSenderService;

/**
 * Created by Uporabnik on 25. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/mail")
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/email")
    public ResponseEntity sendEmail(@RequestBody Email emailMessage) {

        this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("Success!");

    }
}

package si.um.ris.service.implementation;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import si.um.ris.service.EmailSenderService;

/**
 * Created by Uporabnik on 25. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("eventvista990@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
    }

}

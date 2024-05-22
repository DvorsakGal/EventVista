package si.um.ris.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Created by Uporabnik on 25. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String toWho;
    private String subject;
    private String message;

    public Email() {
    }

    public Email(String to, String message) {
        this.toWho = to;
        this.message = message;
    }

    public Email(String to, String subject, String message) {
        this.toWho = to;
        this.subject = subject;
        this.message = message;
    }

    public String getTo() {
        return toWho;
    }

    public void setTo(String to) {
        this.toWho = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

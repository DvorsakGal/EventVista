package si.um.ris.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Collection;

/**
 * Created by Uporabnik on 21. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */

@Entity
public class Organizator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "organizator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Event> dogodki;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Event> getDogodki() {
        return dogodki;
    }

    public void setDogodki(Collection<Event> dogodki) {
        this.dogodki = dogodki;
    }

    private String ime;
    private String priimek;
    private String email;
    private String telefon;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

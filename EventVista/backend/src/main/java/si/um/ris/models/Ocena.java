package si.um.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Created by Uporabnik on 28. 12. 2023
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@Entity
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int ocena;
    private String komentar;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upor_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Upor uporabnik;

    public Ocena(Long id, int ocena, String komentar, Event event, Upor uporabnik) {
        this.id = id;
        this.ocena = ocena;
        this.komentar = komentar;
        this.event = event;
        this.uporabnik = uporabnik;
    }

    public Ocena() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Upor getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(Upor uporabnik) {
        this.uporabnik = uporabnik;
    }
}

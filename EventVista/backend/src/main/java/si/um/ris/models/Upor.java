package si.um.ris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Collection;

/**
 * Created by Uporabnik on 14. 12. 2023
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@Entity
public class Upor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "ocena", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Ocena> oceneUporabnika;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Event event;
    private String ime;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id=id;
    }

    public Upor(Event event, String ime) {
        this.event = event;
        this.ime = ime;
    }

    public Upor(Long id, Collection<Ocena> oceneUporabnika, Event event, String ime) {
        this.id = id;
        this.oceneUporabnika = oceneUporabnika;
        this.event = event;
        this.ime = ime;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}

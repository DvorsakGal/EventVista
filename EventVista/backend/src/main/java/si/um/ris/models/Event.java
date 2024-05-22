package si.um.ris.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by Uporabnik on 14. 12. 2023
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Upor> prijavljeniUpor;

    @OneToMany(mappedBy = "ocena", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Ocena> oceneZaEvent;

    /*
    @OneToOne(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Termin termin;

     */


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Upor> getPrijavljeneUporabnike() {
        return prijavljeniUpor;
    }
    public void setPrijavljeneUporabnike(Collection<Upor> prijavljeniUporabniki) {
        this.prijavljeniUpor = prijavljeniUporabniki;
    }
    private String ime;
    private String organizator;
    private LocalDate datum;
    private LocalTime cas;
    @Enumerated(EnumType.STRING)
    private Interesi[] interes;
    //private Upor[] prijavljeniUporabniki;

    /*
    public Event(String ime, Organizator organizator, Termin termin, int kapaciteta) {
        this.ime = ime;
        this.organizator = organizator;
        this.termin = termin;
        this.prijavljeniUporabniki = new Upor[kapaciteta];
    }

     */

    public Event(String ime, String organizator) {
        this.ime = ime;
        this.organizator = organizator;
    }

    public Event(String ime, String organizator, LocalDate datum, LocalTime cas, Interesi[] interes) {
        this.ime = ime;
        this.organizator = organizator;
        this.datum = datum;
        this.cas = cas;
        this.interes = interes;
    }

    public Event() {
    }

    public Event(Long id, Collection<Upor> prijavljeniUpor, Collection<Ocena> oceneZaEvent, String ime, String organizator, LocalDate datum, LocalTime cas, Interesi[] interes) {
        this.id = id;
        this.prijavljeniUpor = prijavljeniUpor;
        this.oceneZaEvent = oceneZaEvent;
        this.ime = ime;
        this.organizator = organizator;
        this.datum = datum;
        this.cas = cas;
        this.interes = interes;
    }

    public Event(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOrganizator() {
        return organizator;
    }

    public void setOrganizator(String organizator) {
        this.organizator = organizator;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getCas() {
        return cas;
    }

    public void setCas(LocalTime cas) {
        this.cas = cas;
    }

    public Interesi[] getInteres() {
        return interes;
    }

    public void setInteres(Interesi[] interes) {
        this.interes = interes;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", prijavljeniUpor=" + prijavljeniUpor +
                ", oceneZaEvent=" + oceneZaEvent +
                ", ime='" + ime + '\'' +
                ", organizator='" + organizator + '\'' +
                ", datum=" + datum +
                ", cas=" + cas +
                ", interes=" + Arrays.toString(interes) +
                '}';
    }
}

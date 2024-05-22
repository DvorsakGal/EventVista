package si.um.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.ris.models.Event;
import si.um.ris.models.Interesi;
import si.um.ris.repository.IEventRepo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Uporabnik on 14. 12. 2023
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {
    @Autowired
    private IEventRepo eventRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello eventi";
    }

    @GetMapping
    public Iterable<Event> vrniEvente() {
        return eventRepository.findAll();
    }

    @PostMapping
    public Event dodajEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> vrniEvent(@PathVariable Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);

        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
        Optional<Event> obstojecEventOptional = eventRepository.findById(eventId);

        if (obstojecEventOptional.isPresent()) {
            Event obstojecEvent = obstojecEventOptional.get();

            //posodobi lastnosti obstojecega eventa
            obstojecEvent.setIme(updatedEvent.getIme());
            obstojecEvent.setOrganizator(updatedEvent.getOrganizator());
            obstojecEvent.setDatum(updatedEvent.getDatum());
            obstojecEvent.setCas(updatedEvent.getCas());
            obstojecEvent.setInteres(updatedEvent.getInteres());
            //dodaj se druge lastnosti

            //shrani spremembe
            Event savedEvent = eventRepository.save(obstojecEvent);
            return ResponseEntity.ok(savedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        if (eventOptional.isPresent()) {
            Event eventToDelete = eventOptional.get();

            // Delete the event from the repository
            eventRepository.delete(eventToDelete);

            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //METODA, KI VRNE VSE EVENTE PRED 20:00 URO, KI IMAJO MED INTERESI AI, RAČUNALNIŠTVO ALI ZNANOST
    @GetMapping("/{cas}/{interes}")
    public Iterable<Event> iskanjePoDvehParam(@PathVariable LocalTime cas, @PathVariable Interesi interes) {
        LocalTime time = LocalTime.parse("20:00");
        ArrayList<Event> eventi = (ArrayList<Event>) eventRepository.findAll();
        ArrayList<Event> eventiZaVrnit = new ArrayList<>();
        for (int i = 0; i < eventi.size(); i++) {
            System.out.println("v prvi for zanki");
            if (eventi.get(i).getCas().isBefore(time)) {
                System.out.println("cas je ustrezen");
                Interesi[] interesiArr = eventi.get(i).getInteres();
                System.out.println(Arrays.toString(interesiArr));
                for (int j = 0; j < interesiArr.length; j++) {
                    System.out.println("v drugi for zanki");
                    if (interesiArr[j] == Interesi.AI || interesiArr[j] == Interesi.RAČUNALNIŠTVO || interesiArr[j] == Interesi.ZNANOST) {
                        System.out.println("event ustreza vsem merilom");
                        eventiZaVrnit.add(eventi.get(i));
                    }
                }
            }
        }

        return eventiZaVrnit;
    }

}

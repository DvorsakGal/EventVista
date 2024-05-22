package si.um.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.ris.models.Ocena;
import si.um.ris.repository.IEventRepo;
import si.um.ris.repository.IOceneRepo;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Uporabnik on 28. 12. 2023
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */

@RestController
@RequestMapping("/ocene")
@CrossOrigin(origins = "http://localhost:3000")
public class OcenaController {
    @Autowired
    private IOceneRepo oceneRepository;
    @Autowired
    private IEventRepo eventRepository;

    @GetMapping("/halo")
    public String hello() {
        return "hello ocene";
    }

    @GetMapping
    public Iterable<Ocena> vrniOcene() {
        return oceneRepository.findAll();
    }

    @PostMapping("/{id_event}")
    public Optional<Ocena> dodajOceno(@RequestBody Ocena ocena, @PathVariable(name = "id_event") Long id) {
        return eventRepository.findById(id).map(event -> {
            ocena.setEvent(event);
            return  oceneRepository.save(ocena);
        });
    }

    @GetMapping("/{ocenaId}")
    public ResponseEntity<Ocena> vrniOceno(@PathVariable Long ocenaId) {
        Optional<Ocena> ocena = oceneRepository.findById(ocenaId);

        if (ocena.isPresent()) {
            return ResponseEntity.ok(ocena.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{ocenaId}")
    public ResponseEntity<Ocena> updateOcena(@PathVariable Long ocenaId, @RequestBody Ocena updatedOcena) {
        Optional<Ocena> obstojecaOcenaOptional = oceneRepository.findById(ocenaId);

        if (obstojecaOcenaOptional.isPresent()) {
            Ocena obstojecaOcena = obstojecaOcenaOptional.get();

            //posodobi lastnosti obstojece ocene
            obstojecaOcena.setOcena(updatedOcena.getOcena());
            obstojecaOcena.setKomentar(updatedOcena.getKomentar());
            obstojecaOcena.setEvent(updatedOcena.getEvent());
            obstojecaOcena.setUporabnik(updatedOcena.getUporabnik());
            //dodaj se druge lastnosti

            //shrani spremembe
            Ocena savedOcena = oceneRepository.save(obstojecaOcena);
            return ResponseEntity.ok(savedOcena);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{ocenaId}")
    public ResponseEntity<Void> deleteOceno(@PathVariable Long ocenaId) {
        Optional<Ocena> ocenaOptional = oceneRepository.findById(ocenaId);

        if (ocenaOptional.isPresent()) {
            Ocena ocenaToDelete = ocenaOptional.get();

            // Delete the event from the repository
            oceneRepository.delete(ocenaToDelete);

            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //METODA, KI VRNE VSE OCENE VIŠJE OD 8, KI NE/VSEBUJEJO KOMENTAR
    @GetMapping("/{ocena}/{komentar}")
    public Iterable<Ocena> iskanjePoDvehParamOcena(@PathVariable int ocena, @PathVariable boolean komentar) {
        ArrayList<Ocena> ocene = (ArrayList<Ocena>) oceneRepository.findAll();
        ArrayList<Ocena> oceneZaVrnit = new ArrayList<>();
        for (int i = 0; i < ocene.size(); i++) {
            if (ocene.get(i).getOcena() > ocena) {
                if (komentar) {
                    if (ocene.get(i).getKomentar() != null) {
                        oceneZaVrnit.add(ocene.get(i));
                    }
                } else {
                    if (ocene.get(i).getKomentar() == null) {
                        oceneZaVrnit.add(ocene.get(i));
                    }
                }
            }
        }

        return oceneZaVrnit;
    }

}

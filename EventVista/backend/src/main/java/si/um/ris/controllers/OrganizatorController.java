package si.um.ris.controllers;

import si.um.ris.models.Organizator;
import si.um.ris.repository.IOrganizatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Created by Uporabnik on 21. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */

@RestController
@RequestMapping("/organizatorji")
@CrossOrigin("*")
public class OrganizatorController {
    @Autowired
    private IOrganizatorRepo organizatorDao;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping
    public Iterable<Organizator> vrniOrganizatorje() {
        return organizatorDao.findAll();
    }

    @PostMapping
    public Organizator dodajOrganizatorja(@RequestBody Organizator organizator) {
        return organizatorDao.save(organizator);
    }

    @GetMapping("/{ime}")
    public Organizator vrniOrganizatorjaPoImenu(@PathVariable(name = "ime") String ime) {
        return organizatorDao.findByIme(ime);
    }

    @GetMapping("/{id}")
    public Organizator vrniOrganizatorjaPoIdju(@PathVariable Long id) {
        return organizatorDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organizatorja ni mogoče najti s tem ID-jem"));
    }

    @GetMapping("/janOrg")
    public List<Organizator> vrniJanOrganizatorje() {
        return organizatorDao.findByIdLessThanAndIme(55, "jan");
    }

    @DeleteMapping("/izbrisi/{id}")
    public ResponseEntity<String> izbrisiOrganizatorja(@PathVariable(name = "id") Long id) {
        try {
            organizatorDao.deleteById(id);
            return ResponseEntity.ok("Organizator z ID-jem " + id + " uspešno izbrisan.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Organizatorja ni mogoče izbrisati. Organizator z ID-jem " + id + " ne obstaja.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Napaka pri brisanju organizatorja z ID-jem " + id + ": " + e.getMessage());
        }
    }


    @PutMapping("/posodobi/{id}")
    public Organizator posodobiOrganizatorja(@PathVariable(name = "id") Long id, @RequestBody Organizator noviPodatki) {
        return organizatorDao.findById(id)
                .map(organizator -> {
                    organizator.setIme(noviPodatki.getIme());
                    organizator.setPriimek(noviPodatki.getPriimek());
                    organizator.setEmail(noviPodatki.getEmail());
                    organizator.setTelefon(noviPodatki.getTelefon());
                    return organizatorDao.save(organizator);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organizatorja ni mogoče najti s tem ID-jem"));
    }
}

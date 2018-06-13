package it.nextre.academy.realspring.controllers;

import it.nextre.academy.realspring.models.Film;
import it.nextre.academy.realspring.services.FilmService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    //Dichiarazione del logger
    Logger log = Logger.getLogger(FilmController.class);

    @GetMapping("/")
    public List<Film> getAll(){
        log.debug("getAll Film called");
        return filmService.getAll();
    }

    @GetMapping("/{idFilm}")
    public Film getFilmById(@PathVariable("idFilm") Long id){
        log.debug("getFilmById() called");
        if (id!=null){
            return filmService.findById(id);
        }
        return null;
    }

    @GetMapping("/titolo/{taitol}")  // title troppo banale
    public List<Film> getFilmByTitolo(@PathVariable("taitol") String titolo){
        log.debug("getFilmByTitolo() called");
        if (titolo!=null && titolo.length()>0){
            return filmService.findByTitolo(titolo);
        }
        return null;
    }

    @GetMapping("/regista/{regista}")
    public List<Film> getFilmByRegista(@PathVariable("regista") String regista){
        log.debug("getFilmByTitolo() called");
        if (regista!=null && regista.length()>0){
            return filmService.findByRegista(regista);
        }
        return null;
    }

    @PostMapping("/")
    public Film addFilm(@RequestBody Film f1){
        log.debug("addFilm() called with film: " + f1);
        return filmService.add(f1);
    }

    @PutMapping("/{idFilm}")
    public Film updateFilm(@RequestBody Film f1, @PathVariable("idFilm") long id){
        log.debug("updateFilm() called with film: " + f1 + " and id: " + id);
        if (f1.getId()==id) {
            return filmService.save(f1);
        }else{
            return new Film();
        }
    }


    @DeleteMapping("/{idFilm}")
    public Boolean deleteFilm(@RequestBody Film f1, @PathVariable("idFilm") long id){
        log.debug("deleteFilm() called with film: " + f1 + " and id: " + id);
        if (f1.getId()==id) {
            return filmService.delete(f1);
        }else{
            return false;
        }
    }


}//end class

package it.nextre.academy.realspring.controllers;

import it.nextre.academy.realspring.models.Film;
import it.nextre.academy.realspring.services.FilmService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}//end class

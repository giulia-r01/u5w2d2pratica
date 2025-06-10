package it.epicode.u5w2d2pratica.controller;

import it.epicode.u5w2d2pratica.exeption.NotFoundExeption;
import it.epicode.u5w2d2pratica.model.AutoreBlog;
import it.epicode.u5w2d2pratica.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutorePostController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public AutoreBlog saveAutore(@RequestBody AutoreBlog autore){
        return autoreService.saveAutore(autore);
    }

    @GetMapping("/autori/{id}")
    public AutoreBlog getAutore(@PathVariable Long id) throws NotFoundExeption {
        return autoreService.getAutore(id);
    }

    @GetMapping("/autori")
    public List<AutoreBlog> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @PutMapping("/autori/{id}")
    public AutoreBlog updateAutore(@PathVariable Long id, @RequestBody AutoreBlog autore)
            throws NotFoundExeption {
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("/autori/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAutore(@PathVariable Long id) throws NotFoundExeption {
        autoreService.deleteAutore(id);
    }
}

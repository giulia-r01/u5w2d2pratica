package it.epicode.u5w2d2pratica.service;

import it.epicode.u5w2d2pratica.exeption.NotFoundExeption;
import it.epicode.u5w2d2pratica.model.AutoreBlog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    private List<AutoreBlog> autori = new ArrayList<>();

    public AutoreBlog saveAutore(AutoreBlog autore){
        autore.setId(new Random().nextLong(1,3000));
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        autori.add(autore);
        return autore;
    }


    public AutoreBlog getAutore(Long id) throws NotFoundExeption {
        return autori.stream().filter(autore -> autore.getId().equals(id)).
                findFirst().orElseThrow(()->new NotFoundExeption("Non esiste un autore con id "+id));
    }


    public List<AutoreBlog> getAllAutori(){
        return autori;
    }


    public AutoreBlog updateAutore(Long id, AutoreBlog autore) throws NotFoundExeption {
        AutoreBlog autoreDaCercare = getAutore(id);

        autoreDaCercare.setNome(autore.getNome());
        autoreDaCercare.setCognome(autore.getCognome());
        autoreDaCercare.setEmail(autore.getEmail());
        autoreDaCercare.setDataDiNascita(autore.getDataDiNascita());

        return autoreDaCercare;
    }


    public void deleteAutore(Long id) throws NotFoundExeption {
        AutoreBlog autoreDaEliminare = getAutore(id);

        autori.remove(autoreDaEliminare);
    }

}

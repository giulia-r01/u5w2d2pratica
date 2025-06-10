package it.epicode.u5w2d2pratica.service;

import it.epicode.u5w2d2pratica.exeption.PostNotFoundExeption;
import it.epicode.u5w2d2pratica.model.PostBlog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PostBlogService {
    private List<PostBlog> postBlogs = new ArrayList<>();

    //creare un post
    public PostBlog savePostBlog(PostBlog postBlog){
        postBlog.setId(new Random().nextLong(1,2000));
        postBlog.setCover("https://picsum.photos/200/300");
        postBlogs.add(postBlog);
        return postBlog;
    }

    //get singolo post
    public PostBlog getPostBlog(long id) throws PostNotFoundExeption {
        return postBlogs.stream().filter(postBlog -> postBlog.getId().equals(id))
                .findFirst().orElseThrow(()-> new PostNotFoundExeption("Non esiste un post con id "+id));
    }

    //get tutti i posts
    public List<PostBlog> getAllPostsBlog(){
        return postBlogs;
    }

    public PostBlog updatePostBlog(long id, PostBlog postBlog) throws PostNotFoundExeption {
        PostBlog postDaCercare = getPostBlog(id);

        postDaCercare.setTitolo(postBlog.getTitolo());
        postDaCercare.setCategoria(postBlog.getCategoria());
        postDaCercare.setContenuto(postBlog.getContenuto());
        postDaCercare.setTempoDiLettura(postBlog.getTempoDiLettura());

        return postDaCercare;
    }

    public void deletePostBlog(Long id) throws PostNotFoundExeption {
        PostBlog postDaRimuovere = getPostBlog(id);

        postBlogs.remove(postDaRimuovere);
    }


}

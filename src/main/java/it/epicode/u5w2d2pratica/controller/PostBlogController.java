package it.epicode.u5w2d2pratica.controller;

import it.epicode.u5w2d2pratica.exeption.NotFoundExeption;
import it.epicode.u5w2d2pratica.model.PostBlog;
import it.epicode.u5w2d2pratica.service.PostBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostBlogController {

    @Autowired
    private PostBlogService postBlogService;

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public PostBlog savePostBlog(@RequestBody PostBlog postBlog){
        return postBlogService.savePostBlog(postBlog);
    }

    @GetMapping("/posts/{id}")
    public PostBlog getPostBlog(@PathVariable Long id) throws NotFoundExeption {
        return postBlogService.getPostBlog(id);
    }

    @GetMapping("/posts")
    public List<PostBlog> getAllPosts(){
        return postBlogService.getAllPostsBlog();
    }

    @PutMapping("/posts/{id}")
    public  PostBlog updatePostBlog(@PathVariable Long id, @RequestBody PostBlog postBlog) throws NotFoundExeption {
        return postBlogService.updatePostBlog(id, postBlog);
    }

    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) throws NotFoundExeption {
        postBlogService.deletePostBlog(id);
    }


}

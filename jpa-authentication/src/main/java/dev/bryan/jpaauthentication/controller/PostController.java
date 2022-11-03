package dev.bryan.jpaauthentication.controller;

import dev.bryan.jpaauthentication.model.Post;
import dev.bryan.jpaauthentication.repository.PostRespository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRespository postRespository;

    public PostController(PostRespository postRespository) {
        this.postRespository = postRespository;
    }

    @GetMapping()
    public Iterable<Post> findAll (){
        return postRespository.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") Post post){
        return post;
    }


}

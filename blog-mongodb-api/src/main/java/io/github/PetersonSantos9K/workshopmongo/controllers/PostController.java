package io.github.PetersonSantos9K.workshopmongo.controllers;

import io.github.PetersonSantos9K.workshopmongo.controllers.util.URL;
import io.github.PetersonSantos9K.workshopmongo.domain.Post;
import io.github.PetersonSantos9K.workshopmongo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findById(){

        return ResponseEntity.ok().body(postService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){

        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullsearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate){

        text = URL.decodeParam(text);

        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> posts = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(posts);
    }


}

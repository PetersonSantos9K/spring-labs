
package io.github.PetersonSantos9K.workshopmongo.services;

import io.github.PetersonSantos9K.workshopmongo.domain.Post;
import io.github.PetersonSantos9K.workshopmongo.repositories.PostRepository;
import io.github.PetersonSantos9K.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public Post findById(String id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findAll(){
        return repository.findAll();
    }

    public List<Post> findByTitle(String title){
        return repository.findByTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}

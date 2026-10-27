package io.github.PetersonSantos9K.workshopmongo.controllers;

import io.github.PetersonSantos9K.workshopmongo.domain.Post;
import io.github.PetersonSantos9K.workshopmongo.dto.api.request.UserRequestDTO;
import io.github.PetersonSantos9K.workshopmongo.dto.api.request.UserUpdateRequestDTO;
import io.github.PetersonSantos9K.workshopmongo.dto.api.response.UserResponseDTO;
import io.github.PetersonSantos9K.workshopmongo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO dto){
        UserResponseDTO responseDTO = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserUpdateRequestDTO dto){
        dto.setId(id);
        service.update(dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        return ResponseEntity.ok().body(service.findPosts(id));
    }

}

package io.github.PetersonSantos9K.workshopmongo.services;

import io.github.PetersonSantos9K.workshopmongo.domain.Post;
import io.github.PetersonSantos9K.workshopmongo.domain.User;
import io.github.PetersonSantos9K.workshopmongo.dto.api.request.UserRequestDTO;
import io.github.PetersonSantos9K.workshopmongo.dto.api.request.UserUpdateRequestDTO;
import io.github.PetersonSantos9K.workshopmongo.dto.api.response.UserResponseDTO;
import io.github.PetersonSantos9K.workshopmongo.repositories.UserRepository;
import io.github.PetersonSantos9K.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repo;

    public List<UserResponseDTO> findAll(){
        List<User> list = repo.findAll();
        return list.stream().map(UserResponseDTO::new).toList();
    }

    public UserResponseDTO findById(String id){
        User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return new UserResponseDTO(user);
    }

    public UserResponseDTO insert(UserRequestDTO user){
        return new UserResponseDTO(repo.save(fromDTO(user)));
    }

    public void delete(String id){

        if(!repo.existsById(id)){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

        repo.deleteById(id);
    }

    public UserResponseDTO update(UserUpdateRequestDTO obj){
        User newObj = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(newObj, obj);
        repo.save(newObj);

        return new UserResponseDTO(newObj);
    }

    public List<Post> findPosts(String userId){
        User user = repo.findById(userId).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return user.getPosts();
    }

    private User fromDTO (UserRequestDTO objDTO){
        return new User(null, objDTO.getName(), objDTO.getEmail());
    }

    private void updateData(User user, UserUpdateRequestDTO requestDTO){
        user.setEmail(requestDTO.getEmail());
        user.setName(requestDTO.getName());
    }




}

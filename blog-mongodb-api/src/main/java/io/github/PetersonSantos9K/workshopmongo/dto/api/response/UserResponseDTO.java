package io.github.PetersonSantos9K.workshopmongo.dto.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.PetersonSantos9K.workshopmongo.domain.Post;
import io.github.PetersonSantos9K.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UserResponseDTO implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    public UserResponseDTO(){}

    public UserResponseDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }


}


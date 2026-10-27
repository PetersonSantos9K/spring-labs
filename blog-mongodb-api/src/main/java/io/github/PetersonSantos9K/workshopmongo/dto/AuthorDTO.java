package io.github.PetersonSantos9K.workshopmongo.dto;

import io.github.PetersonSantos9K.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO(){}

    public AuthorDTO(User obj){
        this.id = obj.getId();
        this.name = obj.getName();
    }

}

package io.github.PetersonSantos9K.workshopmongo.dto.api.request;

import io.github.PetersonSantos9K.workshopmongo.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UserRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;

    public UserRequestDTO(){}

    public UserRequestDTO(User obj) {
        name = obj.getName();
        email = obj.getEmail();
    }

}

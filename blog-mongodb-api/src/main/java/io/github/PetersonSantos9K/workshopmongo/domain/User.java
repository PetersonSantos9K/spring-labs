package io.github.PetersonSantos9K.workshopmongo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



@Document(collection = "user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;

    @Getter
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();


    public User(){}

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

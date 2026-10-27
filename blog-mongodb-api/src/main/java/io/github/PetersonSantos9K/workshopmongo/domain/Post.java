package io.github.PetersonSantos9K.workshopmongo.domain;

import io.github.PetersonSantos9K.workshopmongo.dto.AuthorDTO;
import io.github.PetersonSantos9K.workshopmongo.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "post")
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    private String id;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String body;
    @Getter
    @Setter
    private AuthorDTO author;

    @Getter
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(){}

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

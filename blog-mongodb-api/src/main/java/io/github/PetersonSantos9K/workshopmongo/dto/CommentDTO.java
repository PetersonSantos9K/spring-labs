package io.github.PetersonSantos9K.workshopmongo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private LocalDate date;
    private AuthorDTO author;

    public CommentDTO(){}

    public CommentDTO(String text, LocalDate date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

}

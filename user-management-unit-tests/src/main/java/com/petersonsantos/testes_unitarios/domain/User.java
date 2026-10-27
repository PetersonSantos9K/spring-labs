package com.petersonsantos.testes_unitarios.domain;

import com.petersonsantos.testes_unitarios.dtos.UserCreateDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String password;



    public User(UserCreateDTO data){
        this.username = data.name();
        this.email = data.email();
        this.password = data.password();
    }

}

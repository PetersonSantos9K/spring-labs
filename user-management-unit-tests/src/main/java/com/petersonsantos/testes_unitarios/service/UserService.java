package com.petersonsantos.testes_unitarios.service;

import com.petersonsantos.testes_unitarios.domain.User;
import com.petersonsantos.testes_unitarios.dtos.UserCreateDTO;
import com.petersonsantos.testes_unitarios.dtos.UserLoginDTO;
import com.petersonsantos.testes_unitarios.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";


    public User create(UserCreateDTO data){

        valid(data.name(), data.email(), data.password());

        String name = data.name().trim();
        String email = data.email().trim();
        String password = data.password().trim();

        checkLength(name, email, password);
        if(userRepository.existsByEmail(data.email())){
            throw new IllegalArgumentException("This email is already registered.");
        }

        return userRepository.save(new User(data));
    }

    public User login(UserLoginDTO data){

        valid(data.email(), data.password());
        String email = data.email().trim();
        String password = data.password().trim();

        User dataUserEmail = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("No account registered with this email."));

        if(dataUserEmail.getPassword().equals(password)){
            return dataUserEmail;
        }
        throw new IllegalArgumentException("Invalid password");
    }

    public User findById(UUID id){


        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The UUID is incorrect."));
    }

    private void checkLength(String name, String email, String password){

        if(name.length() < 4){
            throw new IllegalArgumentException("The username must have at least 4 characters.");
        }
        if(name.length() > 30){
            throw new IllegalArgumentException("The username cannot be longer than 30 characters.");
        }

        if(!email.matches(EMAIL_REGEX)){
            throw new IllegalArgumentException("E-mail invalid.");
        }

        if(password.length() < 6){
            throw new IllegalArgumentException("The password must be at least 6 characters long.");
        }
    }

    private void valid(String... values ){

        for(String value : values){
            if(value == null){
                throw new IllegalArgumentException("All fields must be filled in.");
            }

            if(value.isBlank()){
                throw new IllegalArgumentException("No field can be empty");
            }
        }

    }




}

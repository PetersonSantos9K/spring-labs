package com.petersonsantos.testes_unitarios.service;

import com.petersonsantos.testes_unitarios.domain.User;
import com.petersonsantos.testes_unitarios.dtos.UserCreateDTO;
import com.petersonsantos.testes_unitarios.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create user successfully when everything is OK")
    void createUserCase1() {
        UserCreateDTO createSuccess1= new UserCreateDTO("Maria Silva", "maria.silva@example.com", "senha123");
        userService.create(createSuccess1);

        verify(repository, times(1)).save(any());
    }

    @Test
    @DisplayName("Should throw Exception when User is not failed for creater")
    void createUserCase2(){
        UserCreateDTO createException1 = new UserCreateDTO("Ana", "ana@example.com", "senha123");


        var thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.create(createException1);
        });

        Assertions.assertEquals("The username must have at least 4 characters.", thrown.getMessage());

        verify(repository, times(0)).save(any());
    }


}
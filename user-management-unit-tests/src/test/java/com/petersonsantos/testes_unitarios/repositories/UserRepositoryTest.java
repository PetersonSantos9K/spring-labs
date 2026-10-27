package com.petersonsantos.testes_unitarios.repositories;

import com.petersonsantos.testes_unitarios.domain.User;
import com.petersonsantos.testes_unitarios.dtos.UserCreateDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get User successfully from DB")
    void findUserByEmailCase1() {
        String email = "peterson@email.com";

        UserCreateDTO data = new UserCreateDTO("Peterson", email, "peterson123");
        this.createUser(data);
        Optional<User> result = this.userRepository.findByEmail(email);
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get User from DB when user not exists")
    void findUserByEmailCase2() {
        String email = "peterson@email.com";

        Optional<User> result = this.userRepository.findByEmail(email);
        assertThat(result.isEmpty()).isTrue();
    }


    private User createUser(UserCreateDTO data){

        User newUser = new User(data);

        this.entityManager.persist(newUser);
        return newUser;
    }


}

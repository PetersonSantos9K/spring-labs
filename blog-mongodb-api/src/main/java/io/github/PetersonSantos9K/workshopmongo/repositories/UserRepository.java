package io.github.PetersonSantos9K.workshopmongo.repositories;

import io.github.PetersonSantos9K.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

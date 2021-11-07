package com.minimarket.lospacos.models.repository;

import com.minimarket.lospacos.models.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    // SELECT * FROM user where email = '' and password = ''
    Optional<User> findByEmailAndPassword(String email, String password);  
    //User findByEmailAndPassword(String email, String password);
  /* 
    List<User> findByName (String name);
    List<User> findByProfileId(Profile profile);*/
}

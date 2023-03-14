package com.example.springmvc.repository;

import com.example.springmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    //data saving database
    User save(User user);

    Optional<User> findUserByEmail(String Email);

    Optional<User> findUserByEmailAndPassword(String email,String password);

}

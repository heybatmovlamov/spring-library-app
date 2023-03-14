package com.example.springmvc.service;

import com.example.springmvc.dto.UserDTO;
import com.example.springmvc.entity.User;
import com.example.springmvc.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public boolean userExist(String email) {
        return findUserByEmail(email).isPresent();
    }

    public User register(UserDTO userDTO) {
        User user = new User();
        modelMapper.map(userDTO, user);
        return userRepository.save(user);
    }

    public Optional<User> existsUserByPassword(String email,String password) {
        return userRepository.findUserByEmailAndPassword(email,password);
    }

    public boolean existsPasswordAndEmail(String email,String password) {
        return existsUserByPassword(email,password).isPresent();
    }
//    public Optional<User> getUserByBooks(){
//        return userRepository.getUserByBooks();
//    }

}

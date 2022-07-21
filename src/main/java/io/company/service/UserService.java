package io.company.service;


import io.company.entity.User;
import io.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // get all USERS
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();

    }

    //CREATE USER
    public User createUser(User user){
        return userRepository.save(user);
    }


    //FIND USER BY ID
    public Optional<User>findUserById(Long id){
        return userRepository.findById(id);
    }
        //DELETE USER BY ID
    public void deleteUserById(Long id){
        userRepository.findById(id);
    }


}

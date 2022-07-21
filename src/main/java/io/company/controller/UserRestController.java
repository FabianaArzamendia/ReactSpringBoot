package io.company.controller;

import io.company.entity.User;
import io.company.entity.Wallet;
import io.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserRestController {

    @Autowired
    UserService userService;

    //CRUD USER   GET ALL USERS
    @RequestMapping(path = "users",  method = RequestMethod.GET)
    public Iterable<User> getAllUsers(){
        return  userService.getAllUsers();


    }
    //CREATE AND SAVE  A USER
    @RequestMapping(path="createUser", method = RequestMethod.POST)
    public User createUser (@RequestBody User user){
        return userService.createUser(user);
    }
       @RequestMapping(path ="getUser", method = RequestMethod.GET)
    public User findUserById(Long id){
        Optional<User> userFound = userService.findUserById(id);
        if(userFound.isPresent()){
            return userFound.get();
        }
        return null;

    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable  Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Operation", "deleteUser");

        Optional<User> userfound = userService.findUserById(id);
        boolean isuser =userfound.isPresent();
        if(isuser){
            userService.deleteUserById(id);
            headers.add("OperationStatus","deleted");
            return  ResponseEntity.accepted().headers(headers).body(userfound.get());

        }else{
            headers.add("OperationStatus","not deleted, not found");
            return ResponseEntity.notFound().headers(headers).build();
        }


    }

}

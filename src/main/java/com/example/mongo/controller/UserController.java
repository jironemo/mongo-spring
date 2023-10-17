package com.example.mongo.controller;

import com.example.mongo.entity.User;
import com.example.mongo.repository.UserRepository;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;
import java.util.List;


@RestController
@RequestMapping("/user/")

@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/all")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        try{
            if(!userRepository.existsByName(user.getName())){
                user = userRepository.save(user);
            }else{
                log.debug("User already exists");
                return new ResponseEntity<>("User already exists",HttpStatus.BAD_REQUEST);

            }
        }catch(NullPointerException nullPE){
            log.debug(nullPE.getMessage());
            return new ResponseEntity<>("User insert failed",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User "+user.getName() +"added successfully.",HttpStatus.OK);

    }




}

package com.api.Auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Auth.models.User;
import com.api.Auth.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    
    @Autowired
    private UserService UserService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getTaskById(@PathVariable Long id){
        User obj = this.UserService.getUserbyId(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User obj) {
        User objCreated = this.UserService.createUser(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(objCreated);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> updateUserPassword(@RequestBody User obj, @PathVariable Long id){
        obj.setId(id);
        this.UserService.updatePassword(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        this.UserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
}

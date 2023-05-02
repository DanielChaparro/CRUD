package com.vass.crud.controller;


import com.vass.crud.controller.request.UserRequest;
import com.vass.crud.model.User;
import com.vass.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping(value="/save_user")
    public ResponseEntity<User> saverUser(@RequestBody UserRequest userRequest){
        User user = userService.saveUser(userRequest);
        return ResponseEntity
                .ok()
                .body(user);
    }

    @PutMapping(value = "/update_user/{id}")
    public ResponseEntity<User> updateUser(@RequestParam Long id, @RequestBody String password){
        User user = userService.updateUser(id,password);
        return ResponseEntity
                .ok()
                .body(user);
    }

    @GetMapping(value = "/list_user")
    public ResponseEntity<List<User>> listUser(){
        List<User> users = userService.listUser();
        return ResponseEntity
                .ok()
                .body(users);
    }

    @DeleteMapping(value = "/delete_user/{id}")
    public ResponseEntity<String> deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return ResponseEntity
                .ok("User with id " + id + "deleted successfully");
    }

    @GetMapping(value = "/find_user/{username}")
    public ResponseEntity<User> userFindByUsername(@RequestParam String username){
        User user = userService.findUserName(username);
        return ResponseEntity
                .ok()
                .body(user);
    }

}

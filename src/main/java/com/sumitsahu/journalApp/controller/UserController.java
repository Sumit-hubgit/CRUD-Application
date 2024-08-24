package com.sumitsahu.journalApp.controller;

import com.sumitsahu.journalApp.entity.JournalEntry;
import com.sumitsahu.journalApp.entity.User;
import com.sumitsahu.journalApp.service.JournalEntryService;
import com.sumitsahu.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public List<User>getAll(){
        return userService.getAll();
    }

    @PostMapping
    public void addNewUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?>updateUser(@RequestBody User user, @PathVariable String userName){
        User userIndb=userService.findByUserName(userName);
        if(userIndb!=null){
            userIndb.setUserName(user.getUserName());
            userIndb.setPassword(user.getPassword());
            userService.saveEntry(userIndb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

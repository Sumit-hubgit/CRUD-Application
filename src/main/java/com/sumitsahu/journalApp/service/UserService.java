package com.sumitsahu.journalApp.service;

import com.sumitsahu.journalApp.entity.JournalEntry;
import com.sumitsahu.journalApp.entity.User;
import com.sumitsahu.journalApp.repository.JournalEntryRepository;
import com.sumitsahu.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user){
        passwordEncoder.encode(user.getPassword());
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
    }

//    public void saveNewUser(User user){
//
//        userRepository.save(user);
//    }

    public List<User> getAll(){
        return userRepository.findAll();

    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }


    public User findByUserName(String userName){
        return  userRepository.findByUserName(userName);
    }
}

package com.service;

import com.entity.UserEntity;
import com.repository.UserActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActionService {
    @Autowired
    private UserActionRepository userRepository;

    public Iterable<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(UserEntity user){
        userRepository.save(user);
    }

    public List<UserEntity> login(String username, String password){
        return userRepository.findByEmailAndPassword(username,password);

    }


}
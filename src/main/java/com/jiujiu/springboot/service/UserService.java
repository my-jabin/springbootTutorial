package com.jiujiu.springboot.service;

import com.jiujiu.springboot.model.User;
import com.jiujiu.springboot.repo.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

/**
 * @ClassName UserService
 * @AuThor yanbin.hu
 * @Date 1/22/2019
 * @Description
 **/
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User... users){
        // begin transaction
        Stream.of(users).forEach(this::saveUsers);
    }
}
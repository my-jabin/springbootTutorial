package com.jiujiu.springboot.security;

import com.jiujiu.springboot.model.User;
import com.jiujiu.springboot.repo.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.swing.text.html.Option;

/**
 * @ClassName UserDetailsServiceImpl
 * @AuThor yanbin.hu
 * @Date 1/21/2019
 * @Description
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional =  this.userRepository.findByEmail(email);
        if(!userOptional.isPresent()){
             throw  new UsernameNotFoundException(email);
        }
        return userOptional.get();
    }
}
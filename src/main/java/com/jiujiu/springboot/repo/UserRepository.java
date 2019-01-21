package com.jiujiu.springboot.repo;

import com.jiujiu.springboot.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @ClassName UserRepository
 * @AuThor yanbin.hu
 * @Date 1/21/2019
 * @Description
 **/
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
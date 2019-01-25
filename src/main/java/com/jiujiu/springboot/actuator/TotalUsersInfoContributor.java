package com.jiujiu.springboot.actuator;

import com.jiujiu.springboot.repo.RoleRepository;
import com.jiujiu.springboot.repo.UserRepository;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * @ClassName TotalUsersInfoContributor
 * @AuThor yanbin.hu
 * @Date 1/23/2019
 * @Description  customize the Spring Boot Actuators’ /info endpoint.
 **/
@Component
public class TotalUsersInfoContributor implements InfoContributor {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public TotalUsersInfoContributor(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> userDetails = new HashMap<>();
        userDetails.put("total", this.userRepository.findAll().size());
        builder.withDetail("users",userDetails);

        Map<String, Integer> roleDetails = new HashMap<>();
        roleDetails.put("total", this.roleRepository.findAll().size());
        builder.withDetail("roles",roleDetails);

    }
}
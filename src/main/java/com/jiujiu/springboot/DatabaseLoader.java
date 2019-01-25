package com.jiujiu.springboot;

import com.jiujiu.springboot.model.Link;
import com.jiujiu.springboot.model.Role;
import com.jiujiu.springboot.model.User;
import com.jiujiu.springboot.repo.LinkRepository;
import com.jiujiu.springboot.repo.RoleRepository;
import com.jiujiu.springboot.repo.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @ClassName DatabaseLoader
 * @AuThor yanbin.hu
 * @Date 1/17/2019
 * @Description
 **/
@Component
@Order(2)
public class DatabaseLoader implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private LinkRepository linkRepository;

    public DatabaseLoader(UserRepository userRepository, RoleRepository roleRepository,LinkRepository linkRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this. linkRepository = linkRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("database loader...");

        addUserAndRoles();

        addLinks();
    }

    private void addLinks() {
        Link l = new Link("Link testing","www.google.com");
        this.linkRepository.save(l);
    }

    private void addUserAndRoles() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String secret = "{bcrypt}" + encoder.encode("password");

        Role userRole = new Role("ROLE_USER");
        this.roleRepository.save(userRole);

        Role adminRole = new Role("ROLE_ADMIN");
        this.roleRepository.save(adminRole);

        User user = new User("user@gmail.com","user",secret,true);
        user.addRole(userRole);
        userRepository.save(user);

        User admin = new User("admin@gmail.com","admin",secret,true);
        user.addRole(adminRole);
        userRepository.save(admin);

        User master = new User("master@gmail.com","master",secret,true);
        user.addRoles(userRole,adminRole);
        userRepository.save(master);


    }
}
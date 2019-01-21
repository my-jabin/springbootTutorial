package com.jiujiu.springboot.repo;

import com.jiujiu.springboot.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName RoleRepository
 * @AuThor yanbin.hu
 * @Date 1/21/2019
 * @Description
 **/
public interface RoleRepository extends JpaRepository<Role,Long> {
}
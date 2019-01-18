package com.jiujiu.springboot.repo;

import com.jiujiu.springboot.model.Link;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName LinkRepository
 * @AuThor yanbin.hu
 * @Date 1/17/2019
 * @Description
 **/

public interface LinkRepository extends JpaRepository<Link,Long> {

    Link findByTitle(String title);
}

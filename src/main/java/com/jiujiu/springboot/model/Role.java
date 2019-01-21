package com.jiujiu.springboot.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Role
 * @AuThor yanbin.hu
 * @Date 1/21/2019
 * @Description
 **/
@Entity
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @ManyToMany( mappedBy = "roles")
    private Collection<User> users;
}
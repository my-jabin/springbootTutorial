package com.jiujiu.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @ClassName User
 * @AuThor yanbin.hu
 * @Date 1/18/2019
 * @Description
 **/
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(nullable = false,unique = true)
    @Size(max = 30, min = 8)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false,length = 64)
    private String password;

    @NonNull
    @Column(nullable = false)
    private boolean enable;
}
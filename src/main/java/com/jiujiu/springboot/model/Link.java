package com.jiujiu.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Link
 * @AuThor yanbin.hu
 * @Date 1/17/2019
 * @Description
 **/
@Entity
@Data
@NoArgsConstructor
public class Link extends Auditable{

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String url;

    @OneToMany
    private List<Comment> comments;


}

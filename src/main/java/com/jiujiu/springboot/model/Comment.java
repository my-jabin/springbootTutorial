package com.jiujiu.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Comment
 * @AuThor yanbin.hu
 * @Date 1/17/2019
 * @Description
 **/
@Entity
@Data
@NoArgsConstructor
public class Comment extends Auditable {

    @Id
    @GeneratedValue
    private long id;

    private String body;

    @ManyToOne
    private Link link;
}

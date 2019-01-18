package com.jiujiu.springboot.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Vote
 * @AuThor yanbin.hu
 * @Date 1/17/2019
 * @Description
 **/
@Entity
@Data
@NoArgsConstructor
public class Vote extends Auditable {

    @Id
    @GeneratedValue
    private long id;

    private int vote;

}

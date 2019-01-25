package com.jiujiu.springboot.model;

import com.jiujiu.springboot.annotation.StartWith;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Link
 * @AuThor yanbin.hu
 * @Date 1/17/2019
 * @Description
 **/
@Entity
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Link extends Auditable{

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @NotNull(message = "title is required") // validation rules
    private String title;

    @NonNull
    @Size(min = 4, max = 100, message = "URL must between 4 to 100") // validation rules
    private String url;

    /**
     * customer annotation
     * check whether reference is started with "http" or "https" if it's not null
     * @StartWith(value = {"ws","wss"}) means to check if the reference is start with "ws" or "wss"
     */
    @StartWith
    private String reference;

    @OneToMany
    private List<Comment> comments;


}

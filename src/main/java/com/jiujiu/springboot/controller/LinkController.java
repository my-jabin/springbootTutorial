package com.jiujiu.springboot.controller;

import com.jiujiu.springboot.annotation.Timed;
import com.jiujiu.springboot.exception.LinkNotFoundException;
import com.jiujiu.springboot.model.Link;
import com.jiujiu.springboot.service.LinkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


/**
 * @ClassName LinkController
 * @AuThor yanbin.hu
 * @Date 1/18/2019
 * @Description
 **/
@RestController
@RequestMapping("/link")
public class LinkController {

    private final Logger logger = LoggerFactory.getLogger(LinkController.class);

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    /**
     * @Timed annotation is used for experimentation of spring aop.
     */
    @GetMapping
    @Timed
    public List<Link> read(){
        return this.linkService.findAll();
    }

    @GetMapping("/{id}")
    @Timed
    public Link getLinkById(@PathVariable long id){
        logger.info("find link by id = " +id);
        Optional<Link> link =  this.linkService.findById(id);
        if(link.isPresent()){
            return link.get();
        }else{
            throw new LinkNotFoundException("Cannot find the link with id " + id);
        }
    }




}